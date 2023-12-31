package com.Restaurant.Management.System.RestaurantManagementSystem.services;

import com.Restaurant.Management.System.RestaurantManagementSystem.exceptions.UnAuthorizedAccess;
import com.Restaurant.Management.System.RestaurantManagementSystem.exceptions.UserNotFoundException;
import com.Restaurant.Management.System.RestaurantManagementSystem.models.AggregatedRevenue;

public interface RevenueService {
    public AggregatedRevenue calculateRevenue(long userId, String queryType) throws UnAuthorizedAccess, UserNotFoundException;
}


