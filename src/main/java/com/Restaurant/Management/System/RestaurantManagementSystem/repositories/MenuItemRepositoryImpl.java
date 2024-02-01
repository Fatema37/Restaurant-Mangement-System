package com.Restaurant.Management.System.RestaurantManagementSystem.repositories;

import com.Restaurant.Management.System.RestaurantManagementSystem.models.DietaryRequirement;
import com.Restaurant.Management.System.RestaurantManagementSystem.models.MenuItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class MenuItemRepositoryImpl implements MenuItemRepository{
    HashMap<Long,MenuItem> hashMap = new HashMap<>();
    List<MenuItem> MenuItemList= new ArrayList<>();
    private long nextId = 1;
    @Override
    public MenuItem add(MenuItem menuItem) {
        if(hashMap.containsKey(menuItem.getId())){
            return hashMap.get(menuItem.getId());
        }
       return hashMap.put(menuItem.getId(),menuItem);
    }

    @Override
    public List<MenuItem> getAll() {
        return new ArrayList<>(hashMap.values());
    }

    @Override
    public List<MenuItem> getByDietaryRequirement(DietaryRequirement dietaryRequirement) {
       List<MenuItem> menuItemList = new ArrayList<>();
        for(MenuItem menuItem:hashMap.values()){
            if(menuItem.getDietaryRequirement().equals(dietaryRequirement)){
                menuItemList.add(menuItem);
            }
        }
        return menuItemList;
    }

    @Override
    public Optional<MenuItem> findById(long id) {
        if(hashMap.containsKey(id)){
            return Optional.of(hashMap.get(id));
        }
        return Optional.empty();
    }

    @Override
    public MenuItem save(MenuItem menuItem) {
        long id = nextId++;
        menuItem.setId(id);
        hashMap.put(id,menuItem);
        return menuItem;
    }
}
