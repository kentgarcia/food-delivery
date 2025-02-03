package com.pupspc.onlinefooddelivery.controller;

import com.pupspc.onlinefooddelivery.model.MenuItem;
import com.pupspc.onlinefooddelivery.model.Restaurant;
import com.pupspc.onlinefooddelivery.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/all")
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @GetMapping("/{restaurantId}/menu")
    public List<MenuItem> getMenuByRestaurantId(@PathVariable Long restaurantId) {
        return restaurantService.getMenuByRestaurantId(restaurantId);
    }

    @GetMapping("/{restaurantId}/name")
    public String getRestaurantNameById(@PathVariable Long restaurantId) {
        return restaurantService.getRestaurantNameById(restaurantId);
    }

}