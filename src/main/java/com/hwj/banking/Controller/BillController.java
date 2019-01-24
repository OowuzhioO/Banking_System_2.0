package com.hwj.banking.Controller;

import com.hwj.banking.Entity.Bill;
import com.hwj.banking.Entity.Customer;
import com.hwj.banking.Param.BillParam;
import com.hwj.banking.Service.BillService;
import com.hwj.banking.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bill")
public class BillController {

    @Autowired
    BillService billService;

    @Autowired
    CustomerService customerService;

    @PostMapping("/addBill/{cid}")
    public String addBill(@PathVariable int cid, Bill bill){
        Customer customer = customerService.getCustomer(cid).get();
//        System.out.println("add bill set up customer:" + customer);
        System.out.println("add bill set up bill:" + bill);
        bill.setCustomer_bill(customer);
        billService.addBill(bill);
        return "add BIll successfully";
    }

    @GetMapping("/deleteBill/{id}")
    public String deleteBill(@PathVariable int id) {
        billService.deleteBill(id);
        return "delete Bill successfully";
    }

    @PutMapping("/updateBill")
    public String updateBill(@RequestBody Bill bill){
        billService.updateBill(bill);
        return "update BIll successfully";
    }

    @GetMapping("/queryBill/{id}")
    public String queryBill(@PathVariable int id){
        Bill bill = billService.getBill(id);
        System.out.println(bill);
        return "query bill successfully";
    }

    @GetMapping("/queryBillOfCustomer/{cid}")
    public List<Bill> queryBillsOfCustomer(@PathVariable int cid) {
//        System.out.println("cid in bill:" + cid);
        List<Bill> bills = billService.getAllBillsOfCustomer(cid);
//        System.out.println("================================" + bills.size());
//        for (Bill bill : bills) {
//            System.out.println("+++++++" + bill);
//        }
        List<Bill> billList = new ArrayList<>();
        for (Bill bill : bills){
            billList.add(bill);
        }
        return billList;
//        return new ArrayList<>();
    }

    @GetMapping("/queryAllBills")
    public String queryAllBills(){
        List<Bill> bills =  billService.getAllBills();
        for (Bill bill : bills) {
            System.out.println(bill);
        }

        return "query all bills successfully";
    }

}
