package com.Restaurant.Management.System.RestaurantManagementSystem.adapters;

import com.Restaurant.Management.System.RestaurantManagementSystem.libraries.paytm.PaytmApi;
import com.Restaurant.Management.System.RestaurantManagementSystem.libraries.paytm.PaytmPaymentResponse;
import com.Restaurant.Management.System.RestaurantManagementSystem.models.Payment;
import com.Restaurant.Management.System.RestaurantManagementSystem.models.PaymentStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PaytmAdapter implements PaymentGatewayAdapter{
    @Autowired
    private PaytmApi paytmApi;

    @Override
    public Payment makePayment(long billId, double amount) {
        PaytmPaymentResponse paytmPaymentResponse=  paytmApi.makePayment(billId,amount);
       Payment payment = new Payment();
       payment.setTxnId(paytmPaymentResponse.getTxnId());
      payment.setPaymentStatus(PaymentStatus.valueOf(paytmPaymentResponse.getPaymentStatus()));
      payment.setBillId(billId);
        return payment;
    }
}
