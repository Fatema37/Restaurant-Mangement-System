package com.Restaurant.Management.System.RestaurantManagementSystem.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Map;

@Getter
@Setter
@Component
public class PlaceOrderRequestDto {
    private long userId;
    private Map<Long,Integer> orderedItems;
}
