package com.Restaurant.Management.System.RestaurantManagementSystem.repositories;

import com.Restaurant.Management.System.RestaurantManagementSystem.models.CustomerSession;

import java.util.HashMap;
import java.util.Optional;

public class CustomerSessionRepositoryImpl implements  CustomerSessionRepository{
    HashMap<Long,CustomerSession> hashMap = new HashMap<>();
    @Override
    public CustomerSession save(CustomerSession customerSession) {
        hashMap.put(customerSession.getId(), customerSession);
        return customerSession;
    }

    @Override
    public Optional<CustomerSession> findActiveCustomerSessionByUserId(long userId) {
        if(hashMap.containsKey(userId)){
            return Optional.of(hashMap.get(userId));
        }
        return Optional.empty();
    }
}
