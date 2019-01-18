package com.hwj.banking.ServiceImp;

import com.hwj.banking.Dao.BillDao;
import com.hwj.banking.Dao.CustomerDao;
import com.hwj.banking.Entity.Bill;
import com.hwj.banking.Entity.Customer;
import com.hwj.banking.Param.BillParam;
import com.hwj.banking.Service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillServiceImp implements BillService {

    @Autowired
    CustomerDao customerDao;

    @Autowired
    BillDao billDao;

    @Override
    public void addBill(BillParam billParam) {
        int cid = billParam.getCid();
        Customer customer = customerDao.findById(cid).get();
        Bill bill = new Bill();
        bill.setDate(billParam.getDate());
        bill.setInfo(billParam.getInfo());
        bill.setBalance(billParam.getBalance());
        List<Bill> billList = customer.getBill();
        billList.add(bill);
        customer.setBill(billList);
        bill.setCustomer(customer);
        customerDao.save(customer);
    }

    @Override
    public void deleteBill(int id) {
        billDao.deleteById(id);
    }

    @Override
    public void updateBill(BillParam billParam) {
        int bid = billParam.getId();
        Bill bill = billDao.findById(bid).get();
        bill.setDate(billParam.getDate());
        bill.setInfo(billParam.getInfo());
        bill.setBalance(billParam.getBalance());
        billDao.save(bill);
    }

    @Override
    public Bill getBill(int id) {
        Bill bill = billDao.findById(id).get();
        return bill;
    }

    @Override
    public List<Bill> getAllBills() {
        List<Bill> bills = (List<Bill>) billDao.findAll();
        return bills;
    }

    @Override
    public List<Bill> getAllBillsOfCustomer(int cid) {
        List<Bill> bills = billDao.findAllByCid(cid);
        return bills;
    }
}
