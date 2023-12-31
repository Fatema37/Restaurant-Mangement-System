package com.Restaurant.Management.System.RestaurantManagementSystem.controllers;

import com.Restaurant.Management.System.RestaurantManagementSystem.dtos.MakePaymentRequestDto;
import com.Restaurant.Management.System.RestaurantManagementSystem.dtos.MakePaymentResponseDto;
import com.Restaurant.Management.System.RestaurantManagementSystem.dtos.ResponseStatus;
import com.Restaurant.Management.System.RestaurantManagementSystem.exceptions.InvalidBillException;
import com.Restaurant.Management.System.RestaurantManagementSystem.models.Payment;
import com.Restaurant.Management.System.RestaurantManagementSystem.models.PaymentStatus;
import com.Restaurant.Management.System.RestaurantManagementSystem.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    public MakePaymentResponseDto makePayment(MakePaymentRequestDto makePaymentRequestDto) throws InvalidBillException {
       MakePaymentResponseDto makePaymentResponseDto = new MakePaymentResponseDto();
        Payment payment=  paymentService.makePayment(makePaymentRequestDto.getBillId());
        makePaymentResponseDto.setPaymentStatus(payment.getPaymentStatus());
        makePaymentResponseDto.setTxnId(payment.getTxnId());
        makePaymentResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        return  makePaymentResponseDto;
    }
}
