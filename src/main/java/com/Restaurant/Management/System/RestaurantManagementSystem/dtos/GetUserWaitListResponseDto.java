package com.Restaurant.Management.System.RestaurantManagementSystem.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetUserWaitListResponseDto {
    private int position;
    private ResponseStatus responseStatus;

    @Override
    public String toString() {
        return "GetUserWaitListResponseDto{" +
                "position=" + position +
                ", responseStatus=" + responseStatus +
                '}';
    }
}
