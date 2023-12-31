package com.Restaurant.Management.System.RestaurantManagementSystem;

import com.Restaurant.Management.System.RestaurantManagementSystem.controllers.WaitListController;
import com.Restaurant.Management.System.RestaurantManagementSystem.dtos.AddUserToWaitListRequestDto;
import com.Restaurant.Management.System.RestaurantManagementSystem.dtos.AddUserToWaitListResponseDto;
import com.Restaurant.Management.System.RestaurantManagementSystem.dtos.GetUserWaitListRequestDto;
import com.Restaurant.Management.System.RestaurantManagementSystem.dtos.GetUserWaitListResponseDto;
import com.Restaurant.Management.System.RestaurantManagementSystem.models.User;
import com.Restaurant.Management.System.RestaurantManagementSystem.models.UserType;
import com.Restaurant.Management.System.RestaurantManagementSystem.repositories.UserRepoImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
public class RestaurantManagementSystemApplication implements CommandLineRunner {
	@Autowired
private WaitListController waitListController;
	@Autowired
	private UserRepoImplementation userRepoImplementation;



	public static void main(String[] args) {

		SpringApplication.run(RestaurantManagementSystemApplication.class, args);

	}


	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setId(1l);
		user.setUserType(UserType.CUSTOMER);
		user.setName("Fatema");
		user.setPhone("9019037373");
		user.setPassword("12345");
		userRepoImplementation.save(user);
		AddUserToWaitListRequestDto addUserToWaitListRequestDto = new AddUserToWaitListRequestDto();
        addUserToWaitListRequestDto.setUserId(1L);
		AddUserToWaitListResponseDto addUserToWaitListResponseDto =waitListController.addUserToWaitList(addUserToWaitListRequestDto);
		System.out.println(addUserToWaitListResponseDto);
		GetUserWaitListRequestDto getUserWaitListRequestDto = new GetUserWaitListRequestDto();
		getUserWaitListRequestDto.setUserId(1L);
		GetUserWaitListResponseDto getUserWaitListResponseDto =waitListController.getWaitListStatus(getUserWaitListRequestDto);
		System.out.println(getUserWaitListResponseDto);


	}
}
