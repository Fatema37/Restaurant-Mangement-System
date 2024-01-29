package com.Restaurant.Management.System.RestaurantManagementSystem.controllers;

import com.Restaurant.Management.System.RestaurantManagementSystem.dtos.PlaceOrderRequestDto;
import com.Restaurant.Management.System.RestaurantManagementSystem.dtos.PlaceOrderResponseDto;
import com.Restaurant.Management.System.RestaurantManagementSystem.dtos.ResponseStatus;
import com.Restaurant.Management.System.RestaurantManagementSystem.models.Order;
import com.Restaurant.Management.System.RestaurantManagementSystem.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private PlaceOrderRequestDto placeOrderRequestDto;

    public OrderController(OrderService orderService) {

        this.orderService = orderService;
    }
    public PlaceOrderResponseDto placeOrder(PlaceOrderRequestDto requestDto){
        PlaceOrderResponseDto responseDto = new PlaceOrderResponseDto();
        try {
            Order order = orderService.placeOrder(requestDto.getUserId(), requestDto.getOrderedItems());
            responseDto.setOrder(order);
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
            return responseDto;
        } catch (Exception e){
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
            return responseDto;
        }
    }
}
