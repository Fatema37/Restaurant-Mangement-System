package com.Restaurant.Management.System.RestaurantManagementSystem.repositories;

import com.Restaurant.Management.System.RestaurantManagementSystem.models.DailyRevenue;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class DailyRevenueRepositoryImpl implements DailyRevenueRepository{
    HashMap<Long,DailyRevenue> dailyRevenueHashMap= new HashMap<>();
    @Override
    public DailyRevenue save(DailyRevenue dailyRevenue) {
        dailyRevenueHashMap.put(dailyRevenue.getId(), dailyRevenue);
        return dailyRevenue;
    }

    @Override
    public List<DailyRevenue> getDailyRevenueBetweenDates(Date startDate, Date endDate) {
       List<DailyRevenue> dailyRevenueList = dailyRevenueHashMap.values().stream()
               .filter(dailyRevenue -> isDateInRange(dailyRevenue.getDate(),
                       startDate,endDate)).collect(Collectors.toList());
        return dailyRevenueList;
    }

    private boolean isDateInRange(Date dateToCheck, Date startDate, Date endDate){
        return !dateToCheck.before(startDate) && !dateToCheck.after(endDate);
    }




}
