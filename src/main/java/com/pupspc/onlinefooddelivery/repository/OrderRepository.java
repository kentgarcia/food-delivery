package com.pupspc.onlinefooddelivery.repository;

import com.pupspc.onlinefooddelivery.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderItem, Long> {
    List<OrderItem> findByStatus(String status);
}