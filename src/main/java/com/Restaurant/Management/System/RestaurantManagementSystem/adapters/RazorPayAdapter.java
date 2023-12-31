package com.Restaurant.Management.System.RestaurantManagementSystem.adapters;

import com.Restaurant.Management.System.RestaurantManagementSystem.libraries.razorpay.RazorpayApi;
import com.Restaurant.Management.System.RestaurantManagementSystem.libraries.razorpay.RazorpayPaymentResponse;
import com.Restaurant.Management.System.RestaurantManagementSystem.models.Payment;
import com.Restaurant.Management.System.RestaurantManagementSystem.models.PaymentStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RazorPayAdapter implements PaymentGatewayAdapter{
    @Autowired
    private RazorpayApi razorpayApi;
    @Override
    public Payment makePayment(long billId, double amount) {
    RazorpayPaymentResponse razorpayPaymentResponse = razorpayApi.processPayment(billId,amount);
      Payment payment = new Payment();
      payment.setBillId(billId);
      payment.setTxnId(razorpayPaymentResponse.getTransactionId());
      payment.setPaymentStatus(PaymentStatus.valueOf(razorpayPaymentResponse.getPaymentStatus()));
        return payment;
    }
}
