package com.Restaurant.Management.System.RestaurantManagementSystem.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddUserToWaitListResponseDto {
    private int position;
    private ResponseStatus responseStatus;

    @Override
    public String toString() {
        return "AddUserToWaitListResponseDto{" +
                "position=" + position +
                ", responseStatus=" + responseStatus +
                '}';
    }
}
