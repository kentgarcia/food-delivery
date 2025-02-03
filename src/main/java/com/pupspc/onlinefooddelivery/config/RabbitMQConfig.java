//package com.pupspc.onlinefooddelivery.config;
//
//import org.springframework.amqp.core.*;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class RabbitMQConfig {
//
//    public static final String EXCHANGE_NAME = "order-status-exchange";
//    public static final String QUEUE_NAME = "order-status-queue";
//    public static final String ROUTING_KEY = "order-status-key";
//
//    @Bean
//    public DirectExchange directExchange() {
//        return new DirectExchange(EXCHANGE_NAME);
//    }
//
//    @Bean
//    public Queue queue() {
//        return new Queue(QUEUE_NAME, true); // true for durable queue
//    }
//
//    @Bean
//    public Binding binding(Queue queue, DirectExchange directExchange) {
//        return BindingBuilder.bind(queue).to(directExchange).with(ROUTING_KEY);
//    }
//}
