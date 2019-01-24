package com.hwj.banking.Service;

import com.hwj.banking.Entity.Loan;
import com.hwj.banking.Param.LoanParam;

import java.util.List;

public interface LoanService {

    void addLoan(Loan loan);
    void deleteLoan(int lid);
    void updateLoan(Loan loan);
    List<Loan> getAllLoans();
    Loan getLoan(int lid);
    List<Loan> getLoanOfCustomer(int cid);
}
