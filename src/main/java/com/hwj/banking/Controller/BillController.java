package com.hwj.banking.Controller;

import com.hwj.banking.Entity.Bill;
import com.hwj.banking.Param.BillParam;
import com.hwj.banking.Service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bill")
public class BillController {

    @Autowired
    BillService billService;

    @PostMapping("/addBill")
    public String addBill(@RequestBody BillParam billParam){
        billService.addBill(billParam);
        return "add BIll successfully";
    }

    @GetMapping("/deleteBill/{id}")
    public String deleteBill(@PathVariable int id) {
        billService.deleteBill(id);
        return "delete Bill successfully";
    }

    @PutMapping("/updateBill")
    public String updateBill(@RequestBody BillParam billParam){
        billService.updateBill(billParam);
        return "update BIll successfully";
    }

    @GetMapping("/queryBill/{id}")
    public String queryBill(@PathVariable int id){
        Bill bill = billService.getBill(id);
        System.out.println(bill);
        return "query bill successfully";
    }

    @GetMapping("/queryBillOfCustomer/{cid}")
    public String queryBillsOfCustomer(@PathVariable int cid) {
        List<Bill> bills = billService.getAllBillsOfCustomer(cid);
        for (Bill bill : bills) {
            System.out.println(bill);
        }
        return "query bill of customer successfully";
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
