package com.Restaurant.Management.System.RestaurantManagementSystem.services;

import com.Restaurant.Management.System.RestaurantManagementSystem.exceptions.InvalidDietaryRequirementException;
import com.Restaurant.Management.System.RestaurantManagementSystem.exceptions.UnAuthorizedAccess;
import com.Restaurant.Management.System.RestaurantManagementSystem.exceptions.UserNotFoundException;
import com.Restaurant.Management.System.RestaurantManagementSystem.models.*;
import com.Restaurant.Management.System.RestaurantManagementSystem.repositories.MenuItemRepository;
import com.Restaurant.Management.System.RestaurantManagementSystem.repositories.UserRepository;

import java.util.List;
import java.util.Optional;


public class MenuServiceImpl implements MenuService{
    private MenuItemRepository menuItemRepository;
    private UserRepository userRepo;

    public MenuServiceImpl(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }
    @Override
    public List<MenuItem> getMenuItems(String dietaryPreference) throws InvalidDietaryRequirementException {
        if(dietaryPreference == null || dietaryPreference.isEmpty()) {
         return menuItemRepository.getAll();
     }
        DietaryRequirement dietaryRequirement = DietaryRequirement.valueOf(dietaryPreference);

      if(dietaryRequirement!=DietaryRequirement.VEGAN || dietaryRequirement!=DietaryRequirement.VEG || dietaryRequirement!=DietaryRequirement.NON_VEG) {
          throw new InvalidDietaryRequirementException("Invalid dietary requirement");
      }
        return menuItemRepository.getByDietaryRequirement(dietaryRequirement);
    }

    @Override
    public MenuItem addMenuItem(long userId, String name, double price, String dietaryRequirement, String itemType, String description) throws UserNotFoundException, UnAuthorizedAccess {
        Optional<User> userOptional = userRepo.findById(userId);
        MenuItem menuItem = new MenuItem();
        if(userOptional.isPresent()){
            if(userOptional.get().getUserType().equals(UserType.ADMIN)){
                menuItem.setName(name);
                menuItem.setPrice(price);
                menuItem.setDietaryRequirement(DietaryRequirement.valueOf(dietaryRequirement));
                menuItem.setItemType(ItemType.valueOf(itemType));
                menuItem.setDescription(description);
                menuItemRepository.save(menuItem);
            }
            else {
               throw new UnAuthorizedAccess("User is not authorized to add menu item");
            }
        }
        else{
            throw new UserNotFoundException("User not found");
        }
        return menuItem;
    }

}
