package com.pupspc.onlinefooddelivery.controller;

import com.pupspc.onlinefooddelivery.model.OrderItem;
import com.pupspc.onlinefooddelivery.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public List<OrderItem> getAcceptedOrders() {
        return orderService.getAcceptedOrders();
    }

    @PutMapping("/orders/{orderId}/pickup")
    public void assignDeliveryPersonnel(@PathVariable Long orderId) {
        orderService.assignDeliveryPersonnel(orderId);
    }

    @PutMapping("/orders/{orderId}/arrive")
    public OrderItem arriveOrder(@PathVariable Long orderId) {
        return orderService.updateOrderStatus(orderId, "Arrived");
    }

    @PutMapping("/orders/{orderId}/deliver")
    public OrderItem deliverOrder(@PathVariable Long orderId) {
        return orderService.updateOrderStatus(orderId, "Delivered");
    }
}