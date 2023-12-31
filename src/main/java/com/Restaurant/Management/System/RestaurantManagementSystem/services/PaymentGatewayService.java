package com.Restaurant.Management.System.RestaurantManagementSystem.services;

import com.Restaurant.Management.System.RestaurantManagementSystem.adapters.PaymentGatewayAdapter;
import com.Restaurant.Management.System.RestaurantManagementSystem.adapters.PaytmAdapter;
import com.Restaurant.Management.System.RestaurantManagementSystem.exceptions.InvalidBillException;
import com.Restaurant.Management.System.RestaurantManagementSystem.models.Bill;
import com.Restaurant.Management.System.RestaurantManagementSystem.models.Payment;
import com.Restaurant.Management.System.RestaurantManagementSystem.repositories.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentGatewayService implements PaymentService{
    @Autowired
    private BillRepository billRepository;

    @Autowired
    private PaytmAdapter adapter;

    @Override
    public Payment makePayment(long billId) throws InvalidBillException {
        Optional<Bill> billOptional = billRepository.findById(billId);
        if(billOptional.isEmpty()){
            throw new InvalidBillException("Bill Id is invalid");
        }
        Bill bill = billOptional.get();
        Payment payment = adapter.makePayment(billId, bill.getTotalAmount());
        return payment;
    }
}
