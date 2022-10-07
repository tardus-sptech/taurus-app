import amqp from 'amqplib/callback_api.js';
import { listenToFinanceConfirmationQueue } from '../../modules/finance/rabbitmq/spentConfirmationListener.js'

import {
    SPENT_TOPIC,
    SPENT_VALUE_UPDATE_QUEUE,
    SPENT_VALUE_UPDATE_ROUTING_KEY,
    SPENT_CONFIRMATION_QUEUE,
    SPENT_CONFIRMATION_ROUTING_KEY
} from './queue.js'

import { RABBIT_MQ_URL } from '../constants/secrets.js'

const TWO_SECONDS = 2000;
const HALF_MINUTE = 30000;
const CONTAINER_ENV = "container";

export async function connectRabbitMq() {
    const env = process.env.NODE_ENV;   
    console.info("Waiting for RabbitMQ start...")
    if (CONTAINER_ENV === env) {
        setInterval(() => {
            connectRabbitMqAndCreateQueues();
        }, HALF_MINUTE);
    } else {
        connectRabbitMqAndCreateQueues();
    }
}

function connectRabbitMqAndCreateQueues() {
    amqp.connect(RABBIT_MQ_URL, (error, connection) => {
        if (error) {
            throw error;
        }
        console.info("Starting RabbitMQ...")
        createQueue(connection,
            SPENT_VALUE_UPDATE_QUEUE,
            SPENT_VALUE_UPDATE_ROUTING_KEY,
            SPENT_TOPIC
        );
        createQueue(connection,
            SPENT_CONFIRMATION_QUEUE,
            SPENT_CONFIRMATION_ROUTING_KEY,
            SPENT_TOPIC
        );
        console.info("Queues and Topics were defined.")
        setTimeout(function() {
            connection.close()
        }, TWO_SECONDS);
    });
    setTimeout(function() {
        listenToFinanceConfirmationQueue();
    }, TWO_SECONDS);

}

function createQueue(connection, queue, routingKey, topic) {
    connection.createChannel((error, channel) => {
        if (error) {
            throw error;
        }
        channel.assertExchange(topic, 'topic', { durable: true });
        channel.assertQueue(queue, { durable: true });
        channel.bindQueue( queue, topic, routingKey )
    });
}