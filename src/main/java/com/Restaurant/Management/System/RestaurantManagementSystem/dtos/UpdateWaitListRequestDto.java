package com.Restaurant.Management.System.RestaurantManagementSystem.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
public class UpdateWaitListRequestDto {
    private long userId;
    private int numberOfSeats;
}
