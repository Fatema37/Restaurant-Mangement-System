package com.Restaurant.Management.System.RestaurantManagementSystem.services;

import com.Restaurant.Management.System.RestaurantManagementSystem.exceptions.UnAuthorizedAccess;
import com.Restaurant.Management.System.RestaurantManagementSystem.exceptions.UserNotFoundException;
import com.Restaurant.Management.System.RestaurantManagementSystem.models.*;
import com.Restaurant.Management.System.RestaurantManagementSystem.repositories.DailyRevenueRepositoryImpl;
import com.Restaurant.Management.System.RestaurantManagementSystem.repositories.UserRepoImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class RevenueServiceImplementation implements RevenueService{
    @Autowired
    private UserRepoImplementation userRepoImplementation;
    @Autowired
    private DailyRevenueRepositoryImpl dailyRevenueRepo;

    @Override
    public AggregatedRevenue calculateRevenue(long userId, String queryType) throws UnAuthorizedAccess, UserNotFoundException {
       Optional<User> userOptional = userRepoImplementation.findById(userId);
       if(userOptional.isEmpty()){
           throw new UserNotFoundException("User not found");
       }
       User user = userOptional.get();
       if(user.getUserType().equals(UserType.BILLING)) {
           if (queryType.equals(RevenueQueryType.CURRENT_MONTH)) {
               LocalDate startdate = LocalDate.now().withDayOfMonth(1);
               LocalDate enddate = LocalDate.now().plusMonths(1).withDayOfMonth(1).minusDays(1);
               List<DailyRevenue> dailyRevenueList = dailyRevenueRepo.getDailyRevenueBetweenDates(Date.from(startdate.atStartOfDay(ZoneId.systemDefault()).toInstant())
                       , Date.from(enddate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
               double totalRevenue = 0.0;
               double totalgst = 0.0;
               double servicecharge = 0.0;
               for (DailyRevenue dailyRevenue : dailyRevenueList) {
                   totalRevenue += dailyRevenue.getRevenueFromFoodSales();
                   totalgst += dailyRevenue.getTotalGst();
                   servicecharge = dailyRevenue.getTotalServiceCharge();

               }
               AggregatedRevenue aggregatedRevenue = new AggregatedRevenue();
               aggregatedRevenue.setTotalRevenue(totalRevenue);
               aggregatedRevenue.setFromDate(Date.from(startdate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
               aggregatedRevenue.setToDate(Date.from(enddate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
               aggregatedRevenue.setTotalGst(totalgst);
               aggregatedRevenue.setRevenueFromFoodSales(totalRevenue);
               aggregatedRevenue.setTotalServiceCharge(servicecharge);
               return aggregatedRevenue;

           } else if (queryType.equals(RevenueQueryType.CURRENT_FY)) {
               LocalDate startdate = LocalDate.now().withMonth(4).withDayOfMonth(1);
               LocalDate enddate = LocalDate.now().plusYears(1).withMonth(3).withDayOfMonth(31);
               List<DailyRevenue> dailyRevenueList = dailyRevenueRepo.getDailyRevenueBetweenDates(Date.from(startdate.atStartOfDay(ZoneId.systemDefault()).toInstant())
                       , Date.from(enddate.atStartOfDay(ZoneId.systemDefault()).toInstant()));

               AggregatedRevenue aggregatedRevenue = new AggregatedRevenue();
               double totalRevenue = 0.0;
               double totalgst = 0.0;
               double servicecharge = 0.0;

               for (DailyRevenue dailyRevenue : dailyRevenueList) {
                   totalRevenue += dailyRevenue.getRevenueFromFoodSales();
                   totalgst += dailyRevenue.getTotalGst();
                   servicecharge += dailyRevenue.getTotalServiceCharge();

               }
               AggregatedRevenue aggregatedRevenue1 = new AggregatedRevenue();
               aggregatedRevenue1.setTotalRevenue(totalRevenue);
               aggregatedRevenue1.setRevenueFromFoodSales(totalRevenue);
               aggregatedRevenue1.setTotalServiceCharge(servicecharge);
               aggregatedRevenue1.setFromDate(Date.from(startdate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
               aggregatedRevenue1.setToDate(Date.from(enddate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
               aggregatedRevenue1.setTotalGst(totalgst);
               return aggregatedRevenue1;

           } else if (queryType.equals(RevenueQueryType.PREVIOUS_MONTH)) {
               LocalDate currentdate = LocalDate.now();
               LocalDate startdate = currentdate.minusMonths(1).withDayOfMonth(1);
               LocalDate enddate = currentdate.withDayOfMonth(1).minusDays(1);

               List<DailyRevenue> dailyRevenueList = dailyRevenueRepo.getDailyRevenueBetweenDates(Date.from(startdate.atStartOfDay(ZoneId.systemDefault()).toInstant())
                       , Date.from(enddate.atStartOfDay(ZoneId.systemDefault()).toInstant()));

               AggregatedRevenue aggregatedRevenue = new AggregatedRevenue();
               double totalRevenue = 0.0;
               double totalgst = 0.0;
               double servicecharge = 0.0;

               for (DailyRevenue dailyRevenue : dailyRevenueList) {
                   totalRevenue += dailyRevenue.getRevenueFromFoodSales();
                   totalgst += dailyRevenue.getTotalGst();
                   servicecharge += dailyRevenue.getTotalServiceCharge();

               }
               aggregatedRevenue.setTotalRevenue(totalRevenue);
               aggregatedRevenue.setRevenueFromFoodSales(totalRevenue);
               aggregatedRevenue.setTotalServiceCharge(servicecharge);
               aggregatedRevenue.setFromDate(Date.from(startdate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
               aggregatedRevenue.setToDate(Date.from(enddate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
               aggregatedRevenue.setTotalGst(totalgst);
               return aggregatedRevenue;
           } else if (queryType.equals(RevenueQueryType.PREVIOUS_FY)) {
               LocalDate currentDate = LocalDate.now();
               int currentYear = currentDate.getYear();
               LocalDate startdate = LocalDate.of(currentYear - 1, 4, 1); // Assuming the financial year starts on April 1st
               LocalDate enddate = LocalDate.of(currentYear, 3, 31); // Assuming the financial year ends on March 31st
               List<DailyRevenue> dailyRevenueList = dailyRevenueRepo.getDailyRevenueBetweenDates(Date.from(startdate.atStartOfDay(ZoneId.systemDefault()).toInstant())
                       , Date.from(enddate.atStartOfDay(ZoneId.systemDefault()).toInstant()));

               AggregatedRevenue aggregatedRevenue = new AggregatedRevenue();
               double totalRevenue = 0.0;
               double totalgst = 0.0;
               double servicecharge = 0.0;

               for (DailyRevenue dailyRevenue : dailyRevenueList) {
                   totalRevenue += dailyRevenue.getRevenueFromFoodSales();
                   totalgst += dailyRevenue.getTotalGst();
                   servicecharge += dailyRevenue.getTotalServiceCharge();

               }
               aggregatedRevenue.setTotalRevenue(totalRevenue);
               aggregatedRevenue.setRevenueFromFoodSales(totalRevenue);
               aggregatedRevenue.setTotalServiceCharge(servicecharge);
               aggregatedRevenue.setFromDate(Date.from(startdate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
               aggregatedRevenue.setToDate(Date.from(enddate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
               aggregatedRevenue.setTotalGst(totalgst);
               return aggregatedRevenue;
           }
       }

       return null;
    }
}
