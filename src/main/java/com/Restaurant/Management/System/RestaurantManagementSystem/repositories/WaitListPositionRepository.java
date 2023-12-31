package com.Restaurant.Management.System.RestaurantManagementSystem.repositories;

import com.Restaurant.Management.System.RestaurantManagementSystem.models.WaitListPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WaitListPositionRepository  {
    WaitListPosition save(WaitListPosition waitListPosition);

    List<WaitListPosition> findAll();

    WaitListPosition delete(WaitListPosition waitListPosition);
}
