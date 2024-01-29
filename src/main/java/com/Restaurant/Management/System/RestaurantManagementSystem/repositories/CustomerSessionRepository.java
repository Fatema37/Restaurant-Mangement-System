package com.Restaurant.Management.System.RestaurantManagementSystem.repositories;

import com.Restaurant.Management.System.RestaurantManagementSystem.models.CustomerSession;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerSessionRepository {
    public CustomerSession save(CustomerSession customerSession);

    public Optional<CustomerSession> findActiveCustomerSessionByUserId(long userId);
}
