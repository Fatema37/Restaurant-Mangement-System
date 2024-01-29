package com.Restaurant.Management.System.RestaurantManagementSystem.repositories;

import com.Restaurant.Management.System.RestaurantManagementSystem.models.MenuItem;

import java.util.HashMap;
import java.util.Optional;

public class MenuItemRepositoryImpl implements MenuItemRepository{
    HashMap<Long,MenuItem> hashMap = new HashMap<>();
    @Override
    public MenuItem add(MenuItem menuItem) {
        if(hashMap.containsKey(menuItem.getId())){
            return hashMap.get(menuItem.getId());
        }
       return hashMap.put(menuItem.getId(),menuItem);
    }

    @Override
    public Optional<MenuItem> findById(long id) {
        if(hashMap.containsKey(id)){
            return Optional.of(hashMap.get(id));
        }
        return Optional.empty();
    }
}
