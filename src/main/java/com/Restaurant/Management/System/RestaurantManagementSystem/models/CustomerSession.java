package com.Restaurant.Management.System.RestaurantManagementSystem.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerSession extends BaseModel{
    private User user;
    private CustomerSessionStatus customerSessionStatus;

}
