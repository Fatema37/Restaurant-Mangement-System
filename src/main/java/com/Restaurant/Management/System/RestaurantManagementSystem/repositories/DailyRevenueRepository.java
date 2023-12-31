package com.Restaurant.Management.System.RestaurantManagementSystem.repositories;

import com.Restaurant.Management.System.RestaurantManagementSystem.models.DailyRevenue;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Repository
public interface DailyRevenueRepository {
    public DailyRevenue save(DailyRevenue dailyRevenue);

    public List<DailyRevenue> getDailyRevenueBetweenDates(Date startDate, Date endDate);
}
