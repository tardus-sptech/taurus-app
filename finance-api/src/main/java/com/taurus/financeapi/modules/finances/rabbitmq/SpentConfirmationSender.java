package com.taurus.financeapi.modules.finances.rabbitmq;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.taurus.financeapi.modules.finances.dto.SpentConfirmationDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SpentConfirmationSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${app-config.rabbit.exchange.spent}")
    private String spentTopicExchange;

    @Value("${app-config.rabbit.routingKey.spent-confirmation}")
    private String spentConfirmationKey;

    public void sendSpentConfirmationMessage(SpentConfirmationDTO message) {
        try {
            log.info("Sending message: {}", new ObjectMapper().writeValueAsString(message));
            rabbitTemplate.convertAndSend(spentTopicExchange, spentConfirmationKey, message);
            log.info("Message was sent successfully!");
        } catch (Exception e) {
            log.error("Error while trying to send spent confirmation message: ", e);
        }
    }
}
