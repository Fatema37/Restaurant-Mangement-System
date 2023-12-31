package com.Restaurant.Management.System.RestaurantManagementSystem.services;

import com.Restaurant.Management.System.RestaurantManagementSystem.exceptions.UnauthorizedAccessException;
import com.Restaurant.Management.System.RestaurantManagementSystem.exceptions.UserNotFoundException;

public interface WaitListService {
    int addUserToWaitList(long userId) throws UserNotFoundException;

    int getWaitListPosition(long userId) throws UserNotFoundException;

    void updateWaitList(long adminUserId, int numberOfSpots) throws UserNotFoundException, UnauthorizedAccessException;
}
