package com.hwj.banking.Controller;

import com.hwj.banking.Entity.Loan;
import com.hwj.banking.Param.LoanParam;
import com.hwj.banking.Service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loan")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PostMapping("/addLoan")
    public String addLoan(@RequestBody Loan loan){
        loanService.addLoan(loan);
        return "add Loan successfully";
    }

    @GetMapping("/deleteLoan/{lid}")
    public String deleteLoan(@PathVariable int lid) {
        loanService.deleteLoan(lid);
        return "delete Loan successfully";
    }

    @PutMapping("/updateLoan")
    public String updateLoan(@RequestBody Loan loan) {
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
    public String queryLoanOfCustomer(@PathVariable int cid){
        loanService.getLoanOfCustomer(cid);
        return  "query loan of customer successfully";
    }
}

