package com.Restaurant.Management.System.RestaurantManagementSystem.repositories;

import com.Restaurant.Management.System.RestaurantManagementSystem.models.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Optional;
@Repository
public class UserRepoImplementation implements UserRepository{
    HashMap<Long ,User> userHashMap = new HashMap<>();

    @Override
    public User save(User user) {
     userHashMap.put(user.getId(),user);
        return user;
    }

    @Override
    public Optional<User> findById(long id) {
        if(userHashMap.containsKey(id)){
         return Optional.of(userHashMap.get(id));
        }
        return Optional.empty();
    }
}
