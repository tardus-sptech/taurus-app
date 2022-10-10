import amqp from 'amqplib/callback_api.js';
import { RABBIT_MQ_URL } from '../../../config/constants/secrets.js';
import SpentService from '../service/SpentService.js';

import {
    SPENT_CONFIRMATION_QUEUE,
    SPENT_CONFIRMATION_ROUTING_KEY, SPENT_TOPIC,
    SPENT_VALUE_UPDATE_QUEUE,
    SPENT_VALUE_UPDATE_ROUTING_KEY
} from '../../../config/rabbitmq/queue.js';

export function listenToFinanceConfirmationQueue() {
    amqp.connect(RABBIT_MQ_URL, (error, connection) => {
        if (error) {
            throw error;
        }
        console.info("Listening to Spent Confirmation Queue...")
        connection.createChannel((error, channel) => {
            if (error) {
                throw error;
            }
            channel.consume(SPENT_CONFIRMATION_QUEUE, (message) => {
                console.info(`Receiving message from queue: ${message.content.toString()}`)
                SpentService.updateSpent(message.content.toString());
            },
            {
                noAck: true, 
            }
            )
        })
    });
}