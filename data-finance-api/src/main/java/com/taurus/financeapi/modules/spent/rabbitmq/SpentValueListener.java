package com.taurus.financeapi.modules.spent.rabbitmq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taurus.financeapi.modules.spent.service.SpentService;
import com.taurus.financeapi.modules.spent.dto.SpentValueDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SpentValueListener {
    @Autowired
    private SpentService spentService;

    @RabbitListener(queues = "${app-config.rabbit.queue.spent-value}")
    public void receiveSpentValueMessage(SpentValueDTO spent) throws JsonProcessingException {
        log.info("Receiving message: {}", new ObjectMapper().writeValueAsString(spent));
        spentService.updateSpentValue(spent);
    }
}
