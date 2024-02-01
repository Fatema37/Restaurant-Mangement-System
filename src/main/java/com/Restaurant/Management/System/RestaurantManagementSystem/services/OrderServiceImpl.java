package com.Restaurant.Management.System.RestaurantManagementSystem.services;

import com.Restaurant.Management.System.RestaurantManagementSystem.exceptions.InvalidMenuItem;
import com.Restaurant.Management.System.RestaurantManagementSystem.exceptions.UserNotFoundException;
import com.Restaurant.Management.System.RestaurantManagementSystem.models.*;
import com.Restaurant.Management.System.RestaurantManagementSystem.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class OrderServiceImpl implements OrderService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MenuItemRepository menuItemRepository;
    @Autowired
    private OrderRepository orderRepository;

    private CustomerSessionRepository customerSessionRepository;
    @Override
    public Order placeOrder(long userId, Map<Long, Integer> orderedItems) throws UserNotFoundException, InvalidMenuItem {
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty()){
            throw new UserNotFoundException("User not found");
        }
        User user = userOptional.get();
        Map<MenuItem, Integer> orderDetail = new HashMap<>();
        for(Map.Entry<Long,Integer> entry : orderedItems.entrySet()){
            Long menuItemId = entry.getKey();
            Integer quantity = entry.getValue();
            Optional<MenuItem> optionalMenuItem = menuItemRepository.findById(menuItemId);
            if(optionalMenuItem.isEmpty()){
                throw new InvalidMenuItem("Menu Item is invalid" +menuItemId);
            }

            MenuItem menuItem = optionalMenuItem.get();
            orderDetail.put(menuItem,quantity);
        }
        // Check if an active customer session exists or create one
        Optional<CustomerSession> optionalCustomerSession = customerSessionRepository.findActiveCustomerSessionByUserId(userId);
       CustomerSession customerSession;
        if (optionalCustomerSession.isEmpty()){
            customerSession = new CustomerSession();
            customerSession.setCustomerSessionStatus(CustomerSessionStatus.ACTIVE);
        }
        customerSession = optionalCustomerSession.get();

        Order order = new Order();
        order.setCustomerSession(customerSession);
        order.setOrderedItems(orderDetail);
        orderRepository.save(order);
        return order;
    }
}
