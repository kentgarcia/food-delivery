package com.pupspc.onlinefooddelivery.service;
import com.pupspc.onlinefooddelivery.model.MenuItem;
import com.pupspc.onlinefooddelivery.model.Restaurant;
import com.pupspc.onlinefooddelivery.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public List<MenuItem> getMenuByRestaurantId(Long restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElse(null);
        return restaurant.getMenu();
    }

    public String getRestaurantNameById(Long restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElse(null);
        return restaurant.getName();
    }
}