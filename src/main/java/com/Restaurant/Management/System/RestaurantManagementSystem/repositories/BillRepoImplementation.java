package com.Restaurant.Management.System.RestaurantManagementSystem.repositories;

import com.Restaurant.Management.System.RestaurantManagementSystem.models.Bill;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Optional;
@Repository
public class BillRepoImplementation implements BillRepository{
    private HashMap<Long,Bill>  billHashMap = new HashMap<>();
    private Long prev_id =0L;
    @Override
    public Bill save(Bill bill) {
       prev_id = prev_id+1;
      bill.setId(prev_id);
      billHashMap.put(prev_id,bill);
        return bill;
    }

    @Override
    public Optional<Bill> findById(long billId) {
        if(billHashMap.containsKey(billId)){
            return Optional.of(billHashMap.get(billId));
        }
        else {
            return Optional.empty();
        }
    }
}
