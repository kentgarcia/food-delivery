package com.pupspc.onlinefooddelivery.config;

import com.pupspc.onlinefooddelivery.handler.OrderStatusHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    private final OrderStatusHandler orderStatusHandler;

    public WebSocketConfig(OrderStatusHandler orderStatusHandler) {
        this.orderStatusHandler = orderStatusHandler;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(orderStatusHandler, "/ws/order-status").setAllowedOrigins("*");
    }
}

