package com.Restaurant.Management.System.RestaurantManagementSystem.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class Order extends BaseModel{
    private Customer customer;
    private CustomerSession customerSession;
    private Map<MenuItem, Integer> orderedItems;
}
