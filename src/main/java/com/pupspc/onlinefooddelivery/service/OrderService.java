package com.pupspc.onlinefooddelivery.service;

import com.pupspc.onlinefooddelivery.handler.OrderStatusHandler;
import com.pupspc.onlinefooddelivery.model.OrderItem;
import com.pupspc.onlinefooddelivery.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private TwilioService twilioService;

    public List<OrderItem> getAcceptedOrders() {
        return orderRepository.findByStatus("Accepted");
    }

    private final OrderStatusHandler orderStatusHandler;

    public OrderService(OrderStatusHandler orderStatusHandler) {
        this.orderStatusHandler = orderStatusHandler;
    }

    public void setOrderAsDelivered(Long orderId) {
        OrderItem order = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
        order.setStatus("Delivered");
        orderRepository.save(order);

        String sms = "Your order has been delivered";
        twilioService.sendSms("+639913707845", sms);

        String message = "Order " + orderId + " has been delivered";
        orderStatusHandler.broadcastOrderStatus(message);
    }

    public void assignDeliveryPersonnel(Long orderId) {
        OrderItem order = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
        order.setDeliveryPersonnel("Ezekiel Pinto");
        order.setStatus("In Delivery");
        orderRepository.save(order);

        String message = "Order " + orderId + " is being delivered.";
        orderStatusHandler.broadcastOrderStatus(message);
    }

    public OrderItem placeOrder(OrderItem order) {
        order.setStatus("Pending"); // Set initial status
        OrderItem savedOrder = orderRepository.save(order);

        String message = "Order is pending.";
        orderStatusHandler.broadcastOrderStatus(message);

        return savedOrder;
    }

    public List<OrderItem> getAllOrders() {
        return orderRepository.findAll();
    }

    public OrderItem updateOrderStatus(Long orderId, String status) {
        OrderItem order = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
        order.setStatus(status);
        OrderItem updatedOrder = orderRepository.save(order);

        String message = "Order " + orderId + ": " + status;
        orderStatusHandler.broadcastOrderStatus(message);

        return updatedOrder;
    }

    public OrderItem getOrderById(Long orderId) {
        return orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
    }
}