package com.Restaurant.Management.System.RestaurantManagementSystem.adapters;

import com.Restaurant.Management.System.RestaurantManagementSystem.models.Payment;
import org.springframework.stereotype.Component;


public interface PaymentGatewayAdapter {
    Payment makePayment(long billId, double amount);
}
