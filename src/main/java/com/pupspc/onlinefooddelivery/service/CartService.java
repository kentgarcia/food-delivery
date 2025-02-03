package com.pupspc.onlinefooddelivery.service;

import com.pupspc.onlinefooddelivery.model.CartItem;
import com.pupspc.onlinefooddelivery.model.MenuItem;
import com.pupspc.onlinefooddelivery.model.OrderCartItem;
import com.pupspc.onlinefooddelivery.model.OrderItem;
import com.pupspc.onlinefooddelivery.repository.CartItemRepository;
import com.pupspc.onlinefooddelivery.repository.MenuItemRepository;
import com.pupspc.onlinefooddelivery.repository.OrderCartItemRepository;
import com.pupspc.onlinefooddelivery.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartService {
    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private MenuItemRepository menuItemRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderCartItemRepository orderCartItemRepository;

    public CartItem addItemToCart(Long menuItemId, int quantity) {
        MenuItem menuItem = menuItemRepository.findById(menuItemId).orElseThrow(() -> new RuntimeException("Menu item not found"));
        CartItem cartItem = cartItemRepository.findByMenuItem(menuItem).orElse(new CartItem());
        cartItem.setMenuItem(menuItem);
        cartItem.setQuantity(cartItem.getQuantity() + quantity);
        return cartItemRepository.save(cartItem);
    }

    public List<CartItem> getCartItems() {
        return cartItemRepository.findAll();
    }

    public void updateCartItem(Long cartItemId, int quantity) {
        CartItem cartItem = cartItemRepository.findById(cartItemId).orElseThrow(() -> new RuntimeException("Cart item not found"));
        cartItem.setQuantity(quantity);
        cartItemRepository.save(cartItem);
    }

    public void removeCartItem(Long cartItemId) {
        cartItemRepository.deleteById(cartItemId);
    }

    public void checkout(String customerName, String address, String phone) {
        List<CartItem> cartItems = cartItemRepository.findAll();
        double totalPrice = cartItems.stream().mapToDouble(item -> item.getQuantity() * item.getMenuItem().getPrice()).sum();

        OrderItem order = new OrderItem();
        order.setCustomerName(customerName);
        order.setAddress(address);
        order.setPhone(phone);
        order.setTotalPrice(totalPrice);
        order.setStatus("Pending");

        orderRepository.save(order);

        List<OrderCartItem> orderCartItems = cartItems.stream().map(cartItem -> {
            OrderCartItem orderCartItem = new OrderCartItem();
            orderCartItem.setMenuItem(cartItem.getMenuItem());
            orderCartItem.setQuantity(cartItem.getQuantity());
            orderCartItem.setOrderItem(order);
            return orderCartItem;
        }).collect(Collectors.toList());

        orderCartItemRepository.saveAll(orderCartItems);

        cartItemRepository.deleteAll();
    }
}