package com.Restaurant.Management.System.RestaurantManagementSystem.controllers;

import com.Restaurant.Management.System.RestaurantManagementSystem.dtos.CalculateRevenueRequestDto;
import com.Restaurant.Management.System.RestaurantManagementSystem.dtos.CalculateRevenueResponseDto;
import com.Restaurant.Management.System.RestaurantManagementSystem.exceptions.UnAuthorizedAccess;
import com.Restaurant.Management.System.RestaurantManagementSystem.exceptions.UserNotFoundException;
import com.Restaurant.Management.System.RestaurantManagementSystem.models.AggregatedRevenue;
import com.Restaurant.Management.System.RestaurantManagementSystem.models.RevenueQueryType;
import com.Restaurant.Management.System.RestaurantManagementSystem.services.RevenueService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class RevenueController {
    @Autowired
    private RevenueService revenueService;

    public RevenueService getRevenueService() {

        return revenueService;
    }

    public void setRevenueService(RevenueService revenueService) {

        this.revenueService = revenueService;
    }

    public CalculateRevenueResponseDto calculateRevenue(CalculateRevenueRequestDto requestDto) throws UserNotFoundException, UnAuthorizedAccess {
       CalculateRevenueResponseDto responseDto = new CalculateRevenueResponseDto();
       AggregatedRevenue aggregatedRevenue = revenueService.calculateRevenue(requestDto.getUserId(),requestDto.getRevenueQueryType());
       responseDto.setAggregatedRevenue(aggregatedRevenue);

        return responseDto;
    }
}
