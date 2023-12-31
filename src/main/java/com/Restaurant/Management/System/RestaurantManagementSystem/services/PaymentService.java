package com.Restaurant.Management.System.RestaurantManagementSystem.services;

import com.Restaurant.Management.System.RestaurantManagementSystem.exceptions.InvalidBillException;
import com.Restaurant.Management.System.RestaurantManagementSystem.models.Payment;

public interface PaymentService {
    Payment makePayment(long billId) throws InvalidBillException;
}
