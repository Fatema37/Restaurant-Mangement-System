package com.Restaurant.Management.System.RestaurantManagementSystem.dtos;

import com.Restaurant.Management.System.RestaurantManagementSystem.models.Order;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlaceOrderResponseDto {
    private ResponseStatus responseStatus;
    private Order order;
}
