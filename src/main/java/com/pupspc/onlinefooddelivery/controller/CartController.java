package com.pupspc.onlinefooddelivery.controller;

import com.pupspc.onlinefooddelivery.model.CartItem;
import com.pupspc.onlinefooddelivery.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public CartItem addItemToCart(@RequestParam Long menuItemId, @RequestParam int quantity) {
        return cartService.addItemToCart(menuItemId, quantity);
    }

    @GetMapping("/items")
    public List<CartItem> getCartItems() {
        return cartService.getCartItems();
    }

    @PutMapping("/update")
    public void updateCartItem(@RequestParam Long cartItemId, @RequestParam int quantity) {
        cartService.updateCartItem(cartItemId, quantity);
    }

    @DeleteMapping("/remove")
    public void removeCartItem(@RequestParam Long cartItemId) {
        cartService.removeCartItem(cartItemId);
    }

    @PostMapping("/checkout")
    public void checkout(@RequestParam String customerName, @RequestParam String address, @RequestParam String phone) {
        cartService.checkout(customerName, address, phone);
    }

}