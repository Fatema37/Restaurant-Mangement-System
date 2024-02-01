package com.Restaurant.Management.System.RestaurantManagementSystem.controllers;

import com.Restaurant.Management.System.RestaurantManagementSystem.dtos.*;
import com.Restaurant.Management.System.RestaurantManagementSystem.models.User;
import com.Restaurant.Management.System.RestaurantManagementSystem.services.MenuService;

public class MenuController {
    private MenuService menuService;


    public MenuController(MenuService menuService) {

        this.menuService = menuService;
    }

    public GetMenuItemsResponseDto getMenuItems(GetMenuItemsRequestDto requestDto){
        GetMenuItemsResponseDto responseDto = new GetMenuItemsResponseDto();
        try {
            responseDto.setMenuItems(menuService.getMenuItems(requestDto.getDietaryRequirement()));
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
            return responseDto;
        }
        catch (Exception e){
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
            return responseDto;
        }

    }

    public AddMenuItemResponseDto addMenuItem(AddMenuItemRequestDto requestDto){
      AddMenuItemResponseDto responseDto = new AddMenuItemResponseDto();
      try{
          responseDto.setMenuItem(menuService.addMenuItem(requestDto.getUserId(),requestDto.getName(),requestDto.getPrice(),requestDto.getDietaryRequirement(),requestDto.getItemType(),requestDto.getDescription()));
          responseDto.setStatus(ResponseStatus.SUCCESS);
            return responseDto;

      }
      catch (Exception e) {
          responseDto.setStatus(ResponseStatus.FAILURE);
          return responseDto;
      }

    }
}
