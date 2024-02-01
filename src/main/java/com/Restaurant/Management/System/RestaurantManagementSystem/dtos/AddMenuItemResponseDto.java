package com.Restaurant.Management.System.RestaurantManagementSystem.dtos;

import com.Restaurant.Management.System.RestaurantManagementSystem.models.MenuItem;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddMenuItemResponseDto {
    private ResponseStatus status;
    private MenuItem menuItem;

}
