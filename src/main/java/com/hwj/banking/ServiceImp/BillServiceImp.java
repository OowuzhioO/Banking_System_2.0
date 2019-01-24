package com.hwj.banking.ServiceImp;

import com.hwj.banking.Dao.BillDao;
import com.hwj.banking.Dao.CustomerDao;
import com.hwj.banking.Entity.Bill;
import com.hwj.banking.Entity.Customer;
import com.hwj.banking.Param.BillParam;
import com.hwj.banking.Service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BillServiceImp implements BillService {

    @Autowired
    CustomerDao customerDao;

    @Autowired
    BillDao billDao;

    @Override
    public void addBill(Bill bill) {
//        int cid = bill.getCid();
//        Customer customer = customerDao.findById(cid).get();
//        Bill bill = new Bill();
//        System.out.println("before add bill date time: " + billParam.getDatetime());
//        bill.setDatetime(billParam.getDatetime());
//        System.out.println("after add bill date time: " + bill.getDatetime());
//        bill.setBillInfo(billParam.getBillInfo());
//        bill.setBillBalance(billParam.getBillBalance());
//        List<Bill> billList = customer.getBill();
//        billList.add(bill);
//        customer.setBill(billList);
//        bill.setCustomer_bill(customer);
//        customerDao.save(customer);

//        Customer customer = bill.getCustomer_bill();
//        customer.getBill().add(bill);
//        customerDao.save(customer);
        billDao.save(bill);
    }

    @Override
    public void deleteBill(int id) {
        billDao.deleteById(id);
    }

    @Override
    public void updateBill(Bill bill) {
//        int bid = billParam.getBid();
//        Bill bill = billDao.findById(bid).get();
//        System.out.println("before update bill date time: billParam:  " + billParam.getDatetime());
//        System.out.println("before update bill date time: bill: " + bill.getDatetime());
//        bill.setDatetime(billParam.getDatetime());
//        System.out.println("after update bill date time: bill" + bill.getDatetime());
//        bill.setBillInfo(billParam.getBillInfo());
//        bill.setBillBalance(billParam.getBillBalance());
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
        System.out.println("the customer cid is : ===========" + cid);
//        Optional<Customer> customer = customerDao.findById(cid);
        Customer customer = customerDao.findById(cid).get();
//        System.out.println("bill of customer:" + customer);
        List<Bill> bills = customer.getBill();
        return bills;
//        return new ArrayList<>();

    }
}
