package com.pupspc.onlinefooddelivery.repository;

import com.pupspc.onlinefooddelivery.model.CartItem;
import com.pupspc.onlinefooddelivery.model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    Optional<CartItem> findByMenuItem(MenuItem menuItem);
}