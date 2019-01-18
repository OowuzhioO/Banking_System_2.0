package com.hwj.banking.Service;

import com.hwj.banking.Entity.Bill;
import com.hwj.banking.Param.BillParam;

import java.util.List;

public interface BillService {
    void addBill(BillParam billParam);
    void deleteBill(int id);
    void updateBill(BillParam billParam);
    Bill getBill(int id);
    List<Bill> getAllBills();
    List<Bill> getAllBillsOfCustomer(int cid);
}
