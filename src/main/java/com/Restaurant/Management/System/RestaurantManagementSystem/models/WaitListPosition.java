package com.Restaurant.Management.System.RestaurantManagementSystem.models;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class WaitListPosition  extends BaseModel{
    private User user;
    private Date insertedAt;


}
