package com.pupspc.onlinefooddelivery.repository;

import com.pupspc.onlinefooddelivery.model.OrderCartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderCartItemRepository extends JpaRepository<OrderCartItem, Long> {
}
