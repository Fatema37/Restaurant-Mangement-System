package com.Restaurant.Management.System.RestaurantManagementSystem.repositories;

import com.Restaurant.Management.System.RestaurantManagementSystem.models.WaitListPosition;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Repository
public class WaitListPositionRepoImplementation implements WaitListPositionRepository {
    List<WaitListPosition> waitListPositionList = new ArrayList<>();

    @Override
    public WaitListPosition save(WaitListPosition waitListPosition) {
        waitListPositionList.add(waitListPosition);
        return waitListPosition;
    }

    @Override
    public List<WaitListPosition> findAll() {
        return waitListPositionList;
    }

    @Override
    public WaitListPosition delete(WaitListPosition waitListPosition) {
        waitListPositionList.remove(waitListPosition);
        return waitListPosition;
    }
}
