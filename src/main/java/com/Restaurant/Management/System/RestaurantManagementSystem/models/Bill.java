package com.Restaurant.Management.System.RestaurantManagementSystem.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bill extends BaseModel{
    private double totalAmount;
    private double gst;
    private double serviceCharge;
}
