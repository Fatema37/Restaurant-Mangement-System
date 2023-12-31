package com.Restaurant.Management.System.RestaurantManagementSystem.controllers;

import com.Restaurant.Management.System.RestaurantManagementSystem.dtos.*;
import com.Restaurant.Management.System.RestaurantManagementSystem.services.WaitListService;
import com.Restaurant.Management.System.RestaurantManagementSystem.services.WaitListServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WaitListController {
    @Autowired
    public WaitListServiceImplement waitListServiceImplement;
    @Autowired
    private AddUserToWaitListRequestDto addUserToWaitListRequestDto;
   @Autowired
   private UpdateWaitListRequestDto updateWaitListRequestDto;
   @Autowired
   private GetUserWaitListRequestDto getUserWaitListRequestDto;

    public AddUserToWaitListResponseDto addUserToWaitList(AddUserToWaitListRequestDto requestDto) {
        AddUserToWaitListResponseDto responseDto = new AddUserToWaitListResponseDto();
        try {
            int position =  waitListServiceImplement.addUserToWaitList(requestDto.getUserId());
            responseDto.setPosition(position);
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception e) {
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDto;
    }

    public UpdateWaitListResponseDto updateWaitList(UpdateWaitListRequestDto requestDto) {
        UpdateWaitListResponseDto responseDto = new UpdateWaitListResponseDto();
        try {
            waitListServiceImplement.updateWaitList(requestDto.getUserId(), requestDto.getNumberOfSeats());
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception e) {
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDto;
    }

    public GetUserWaitListResponseDto getWaitListStatus(GetUserWaitListRequestDto requestDto){
        GetUserWaitListResponseDto responseDto = new GetUserWaitListResponseDto();
        try {
            int position =  waitListServiceImplement.getWaitListPosition(requestDto.getUserId());
            responseDto.setPosition(position);
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception e) {
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDto;
    }
}
