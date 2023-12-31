package com.Restaurant.Management.System.RestaurantManagementSystem.dtos;

import com.Restaurant.Management.System.RestaurantManagementSystem.models.PaymentStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MakePaymentResponseDto {
    private ResponseStatus responseStatus;
    private String txnId;
    private PaymentStatus paymentStatus;
}
