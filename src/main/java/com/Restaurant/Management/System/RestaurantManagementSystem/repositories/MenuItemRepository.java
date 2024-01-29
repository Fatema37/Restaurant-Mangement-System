package com.Restaurant.Management.System.RestaurantManagementSystem.repositories;

import com.Restaurant.Management.System.RestaurantManagementSystem.models.MenuItem;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MenuItemRepository {
    MenuItem add(MenuItem menuItem);

    Optional<MenuItem> findById(long id);
}
