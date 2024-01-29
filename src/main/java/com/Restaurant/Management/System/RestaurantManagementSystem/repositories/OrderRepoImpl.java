package com.Restaurant.Management.System.RestaurantManagementSystem.repositories;

import com.Restaurant.Management.System.RestaurantManagementSystem.models.Order;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
@Repository
public class OrderRepoImpl implements OrderRepository{
    HashMap<Long, Order> hashMap = new HashMap<>();
    @Override
    public Order save(Order order) {
        hashMap.put(order.getId(), order);
        return order;
    }
}
