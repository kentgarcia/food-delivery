package com.pupspc.onlinefooddelivery.controller;

import com.pupspc.onlinefooddelivery.model.OrderItem;
import com.pupspc.onlinefooddelivery.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public OrderItem placeOrder(@RequestBody OrderItem order) {
        return orderService.placeOrder(order);
    }

    @GetMapping
    public List<OrderItem> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{orderId}")
    public OrderItem getOrderById(@PathVariable Long orderId) {
        return orderService.getOrderById(orderId);
    }

    @PutMapping("/{orderId}/status")
    public OrderItem updateOrderStatus(@PathVariable Long orderId, @RequestParam String status) {
        return orderService.updateOrderStatus(orderId, status);
    }

    @PutMapping("/{orderId}/accept")
    public OrderItem acceptOrder(@PathVariable Long orderId) {
        return orderService.updateOrderStatus(orderId, "Accepted");
    }

    @PutMapping("/{orderId}/reject")
    public OrderItem rejectOrder(@PathVariable Long orderId) {
        return orderService.updateOrderStatus(orderId, "Rejected");
    }

    @PutMapping("/{orderId}/deliver")
    public OrderItem deliverOrder(@PathVariable Long orderId) {
        return orderService.updateOrderStatus(orderId, "Awaiting Pickup");
    }
}