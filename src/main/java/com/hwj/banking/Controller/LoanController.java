package com.hwj.banking.Controller;

import com.hwj.banking.Dao.CustomerDao;
import com.hwj.banking.Dao.LoanDao;
import com.hwj.banking.Entity.Customer;
import com.hwj.banking.Entity.Loan;
import com.hwj.banking.Param.LoanParam;
import com.hwj.banking.Service.CustomerService;
import com.hwj.banking.Service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loan")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @Autowired
    private CustomerService customerService;

    @PostMapping("/addLoan/{cid}")
    public String addLoan(@PathVariable int cid, Loan loan){
        System.out.println("cid ---------" + cid);
        System.out.println("loan--------------" + loan);
        Customer customer = customerService.getCustomer(cid).get();
//        List<Loan> loanList = customer.getLoans();
//        loanList.add(loan);
//        loan.setCustomer_loan(customer);
        List<Customer> customerList = loan.getCustomer_loan();
        customerList.add(customer);
        loanService.addLoan(loan);
        return "add Loan successfully";
    }

    @GetMapping("/deleteLoan/{lid}")
    public String deleteLoan(@PathVariable int lid) {
        loanService.deleteLoan(lid);
        return "delete Loan successfully";
    }

    @PostMapping("/updateLoan")
    public String updateLoan(Loan loan) {
//        loan.setId(lid);

        int lid = loan.getId();
        Loan oldLoan = loanService.getLoan(lid);
        List<Customer> customerList = oldLoan.getCustomer_loan();
        loan.setCustomer_loan(customerList);
        loanService.updateLoan(loan);
        return "update loan successfully";
    }

    @GetMapping("/queryAllLoans")
    public String queryAllLoans(){
        loanService.getAllLoans();
        return "query all loans successfully";
    }


    @GetMapping("/queryLoan/{lid}")
    public String queryLoan(@PathVariable int lid) {
        loanService.getLoan(lid);
        return "query loan successfyllt";
    }

    @GetMapping("/queryLoanOfCustomer/{cid}")
    public List<Loan> queryLoanOfCustomer(@PathVariable int cid){
        List<Loan> loans = loanService.getLoanOfCustomer(cid);
        return  loans;
    }
}

