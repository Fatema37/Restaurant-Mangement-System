package com.Restaurant.Management.System.RestaurantManagementSystem.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class AddUserToWaitListRequestDto {
    private long userId;

}
