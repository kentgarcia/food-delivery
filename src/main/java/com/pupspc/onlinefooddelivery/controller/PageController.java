package com.pupspc.onlinefooddelivery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @GetMapping("/register")
    public String showRegisterForm() {
        return "register";
    }

    @GetMapping("/shop")
    public String shop() {
        return "shop";
    }

    @GetMapping("/menu")
    public String menu() {
        return "menu";
    }

    @GetMapping("/checkout")
    public String checkout() {
        return "checkout";
    }

    @GetMapping("/order")
    public String order() {
        return "orders";
    }

    @GetMapping("/order/details")
    public String orderDetails() {
        return "order-details";
    }

    @GetMapping("/restaurant/dashboard")
    public String restaurantDashboard() {
        return "owner/dashboard";
    }

    @GetMapping("/restaurant/orders")
    public String restaurantOrders() {
        return "owner/orders";
    }

    @GetMapping("/delivery/dashboard")
    public String deliveryDashboard() {
        return "delivery/dashboard";
    }

    @GetMapping("/restaurant/order-details")
    public String restaurantOrderDetails() {
        return "owner/order-details";
    }

    @GetMapping("/delivery/order-details")
    public String deliveryOrderDetails() {
        return "delivery/order-details";
    }

    @GetMapping("/restaurant/login")
    public String restaurantLogin() {
        return "owner/login";
    }

    @GetMapping("/delivery/login")
    public String deliveryLogin() {
        return "delivery/login";
    }

    @GetMapping("/delivery/history")
    public String deliveryHistory() {
        return "delivery/history";
    }

    @GetMapping("/delivery/account")
    public String deliveryAccount() {
        return "delivery/account";
    }
}