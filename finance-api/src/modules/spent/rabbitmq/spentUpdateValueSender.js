import amqp from "amqplib/callback_api.js";

import { RABBIT_MQ_URL } from "../../../config/constants/secrets.js"
import {
  SPENT_TOPIC,
  SPENT_VALUE_UPDATE_ROUTING_KEY,
} from "../../../config/rabbitmq/queue.js";

export function sendMessageToSpentValueUpdateQueue(message) {
  amqp.connect(RABBIT_MQ_URL, (error, connection) => {
    if (error) {
      throw error;
    }
    connection.createChannel((error, channel) => {
      if (error) {
        throw error;
      }
      let jsonStringMessage = JSON.stringify(message);
      console.info(`Sending message to spent update value: ${jsonStringMessage}`)
      channel.publish(
        SPENT_TOPIC,
        SPENT_VALUE_UPDATE_ROUTING_KEY,
        Buffer.from(jsonStringMessage)
      );
      console.info("Message was sent successfully.")
    });
  });
}