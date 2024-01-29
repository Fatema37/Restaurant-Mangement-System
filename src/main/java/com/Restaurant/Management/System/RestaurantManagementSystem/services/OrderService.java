package com.Restaurant.Management.System.RestaurantManagementSystem.services;

import com.Restaurant.Management.System.RestaurantManagementSystem.exceptions.InvalidMenuItem;
import com.Restaurant.Management.System.RestaurantManagementSystem.exceptions.UserNotFoundException;
import com.Restaurant.Management.System.RestaurantManagementSystem.models.Order;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public interface OrderService {
    public Order placeOrder(long userId, Map<Long,Integer> orderedItems) throws UserNotFoundException, InvalidMenuItem;



}
