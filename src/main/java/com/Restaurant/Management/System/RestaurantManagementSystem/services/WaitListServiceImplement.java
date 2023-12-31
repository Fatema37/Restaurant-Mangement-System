package com.Restaurant.Management.System.RestaurantManagementSystem.services;

import com.Restaurant.Management.System.RestaurantManagementSystem.exceptions.UnauthorizedAccessException;
import com.Restaurant.Management.System.RestaurantManagementSystem.exceptions.UserNotFoundException;
import com.Restaurant.Management.System.RestaurantManagementSystem.models.User;
import com.Restaurant.Management.System.RestaurantManagementSystem.models.UserType;
import com.Restaurant.Management.System.RestaurantManagementSystem.models.WaitListPosition;
import com.Restaurant.Management.System.RestaurantManagementSystem.repositories.UserRepository;
import com.Restaurant.Management.System.RestaurantManagementSystem.repositories.WaitListPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class WaitListServiceImplement implements WaitListService{
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private WaitListPositionRepository waitListPositionRepository;

    public WaitListServiceImplement(UserRepository userRepo, WaitListPositionRepository waitListPositionRepository) {
        this.userRepo = userRepo;
        this.waitListPositionRepository = waitListPositionRepository;
    }

    @Override
    public int addUserToWaitList(long userId) throws UserNotFoundException {
        Optional<User> userOptional = userRepo.findById(userId);
        if(userOptional.isEmpty()){
            throw new UserNotFoundException("User not found");
        }

          User user=  userOptional.get();
          List<WaitListPosition> waitListPositionList =  waitListPositionRepository.findAll();
          for(int i=0;i<waitListPositionList.size();i++){
              WaitListPosition waitListPosition = waitListPositionList.get(i);
              if(waitListPosition.getUser().getId()==user.getId()){
                  return i+1;
              }

          }
          WaitListPosition waitListPosition = new WaitListPosition();
          waitListPosition.setUser(user);
          waitListPosition.setInsertedAt(new Date());


          waitListPositionRepository.save(waitListPosition);
        return waitListPositionList.size();
    }

    @Override
    public int getWaitListPosition(long userId) throws UserNotFoundException {
        Optional<User> userOptional = userRepo.findById(userId);
        if(userOptional.isEmpty()){
            throw new UserNotFoundException("User not found");
        }
        User user=  userOptional.get();
        List<WaitListPosition> waitListPositionList =  waitListPositionRepository.findAll();
        for(int i=0;i<waitListPositionList.size();i++){
            WaitListPosition waitListPosition = waitListPositionList.get(i);
            if(waitListPosition.getUser().getId()==user.getId()){
                return i+1;
            }
        }
        return -1;
    }

    @Override
    public void updateWaitList(long adminUserId, int numberOfSpots) throws UserNotFoundException, UnauthorizedAccessException {
        Optional<User> adminOptional = userRepo.findById(adminUserId);
        if(adminOptional.isEmpty()){
            throw new UserNotFoundException("User not found");
        }
        User adminUser = adminOptional.get();
        if(adminUser.getUserType()== UserType.CUSTOMER){
            throw new UnauthorizedAccessException("Access Denied");
        }
        List<WaitListPosition> waitListPositionList =  waitListPositionRepository.findAll();
        WaitListPosition waitListPosition = new WaitListPosition();
        int size = Math.min(numberOfSpots, waitListPositionList.size());
        for(int i=0;i<size;i++){
            waitListPositionRepository.delete(waitListPosition);
//                    waitListPositionRepository.save(waitListPosition);
        }
    }
}
