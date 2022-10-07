import amqp from 'amqplib/callback_api.js';
import {
    SPENT_TOPIC,
    SPENT_VALUE_UPDATE_QUEUE,
    SPENT_VALUE_UPDATE_ROUTING_KEY,
    SPENT_CONFIRMATION_QUEUE,
    SPENT_CONFIRMATION_ROUTING_KEY
} from './queue.js'

import { RABBIT_MQ_URL } from '../constants/secrets.js'

const HALF_SECOND = 500;

export async function connectRabbitMq() {
    amqp.connect(RABBIT_MQ_URL, (error, connection) => {
        if (error) {
            throw error;
        }
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
        setTimeout(function() {
            connection.close()
        }, HALF_SECOND);
    })

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
}