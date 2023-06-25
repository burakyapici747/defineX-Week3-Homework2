package repository;

import model.Bill;

import java.util.*;

public class BillRepository {
    private Map<UUID, Bill> bills = new HashMap<>();

    public void create(Bill bill){
        bills.put(bill.getId(), bill);
    }

    public void deleteById(String id){
        bills.remove(id);
    }

    public List<Bill> getAll(){
        return new ArrayList<>(bills.values());
    }
}
