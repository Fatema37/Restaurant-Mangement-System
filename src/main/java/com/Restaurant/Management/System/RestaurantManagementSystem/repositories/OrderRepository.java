package com.Restaurant.Management.System.RestaurantManagementSystem.repositories;

import com.Restaurant.Management.System.RestaurantManagementSystem.models.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository {
    Order save(Order order);
}
