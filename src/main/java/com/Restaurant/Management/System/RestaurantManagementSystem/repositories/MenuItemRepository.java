package com.Restaurant.Management.System.RestaurantManagementSystem.repositories;

import com.Restaurant.Management.System.RestaurantManagementSystem.models.DietaryRequirement;
import com.Restaurant.Management.System.RestaurantManagementSystem.models.MenuItem;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MenuItemRepository {
    MenuItem add(MenuItem menuItem);
    List<MenuItem> getAll();
    List<MenuItem> getByDietaryRequirement(DietaryRequirement dietaryRequirement);

    Optional<MenuItem> findById(long id);
    MenuItem save(MenuItem menuItem);
}

