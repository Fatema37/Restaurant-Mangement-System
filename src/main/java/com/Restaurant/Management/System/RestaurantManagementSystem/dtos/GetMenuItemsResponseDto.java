package com.Restaurant.Management.System.RestaurantManagementSystem.dtos;

import com.Restaurant.Management.System.RestaurantManagementSystem.models.MenuItem;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class GetMenuItemsResponseDto {
    private List<MenuItem> menuItems;
    private ResponseStatus responseStatus;


}
