package com.taurus.financeapi.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    @Value("${app-config.rabbit.exchange.spent}")
    private String spentTopicExchange;

    @Value("${app-config.rabbit.routingKey.spent-value}")
    private String spentValueKey;

    @Value("${app-config.rabbit.routingKey.spent-confirmation}")
    private String spentConfirmationKey;

    @Value("${app-config.rabbit.queue.spent-value}")
    private String spentValueMq;

    @Value("${app-config.rabbit.queue.spent-confirmation}")
    private String spentConfirmationMq;

    @Bean
    public TopicExchange spentTopicExchange() {
        return new TopicExchange(spentTopicExchange);
    }
    @Bean
    public Queue spentValueMq() {
        return new Queue(spentValueMq, true);
    }
    @Bean
    public Queue spentConfirmationMq() {
        return new Queue(spentConfirmationMq, true);
    }
    @Bean
    public Binding spentValueMqBinding(TopicExchange topicExchange) {
        return BindingBuilder
            .bind(spentValueMq())
            .to(topicExchange)
            .with(spentValueKey);
    }
    @Bean
    public Binding spentConfirmationMqBinding(TopicExchange topicExchange) {
        return BindingBuilder
            .bind(spentConfirmationMq())
            .to(topicExchange)
            .with(spentConfirmationKey);
    }
    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
