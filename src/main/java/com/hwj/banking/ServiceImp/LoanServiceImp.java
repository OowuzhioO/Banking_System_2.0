package com.hwj.banking.ServiceImp;

import com.hwj.banking.Dao.CustomerDao;
import com.hwj.banking.Dao.LoanDao;
import com.hwj.banking.Entity.Customer;
import com.hwj.banking.Entity.Loan;
import com.hwj.banking.Param.LoanParam;
import com.hwj.banking.Service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoanServiceImp implements LoanService {

    @Autowired
    private LoanDao loanDao;

    @Autowired
    private CustomerDao customerDao;

    @Override
    public void addLoan(Loan loan) {
//        int cid = loanParam.getCid();
//        Customer customer = customerDao.findById(cid).get();
//
//        Loan loan = new Loan();
//        loan.setBalance(loanParam.getlBalance());
//        loan.setRemark(loanParam.getlRemark());
//        loan.getCustomer_loan().add(customer);
//        List<Loan> loans = customer.getLoans();
//        loans.add(loan);
//        List<Customer> customers = loan.getCustomer_loan();

//        customerDao.save(customer);
        System.out.println("the loan is ---------" + loan);
        List<Customer> customers = loan.getCustomer_loan();
        for (Customer customer : customers) {
            System.out.println(customer);
        }
//        System.out.println(loan.getCustomer_loan());
        loanDao.save(loan);
    }

    @Override
    public void deleteLoan(int lid) {
        loanDao.deleteById(lid);
    }

    @Override
    public void updateLoan(Loan loan) {
//        int lid = loanParam.getLid();
//        Loan loan = loanDao.findById(lid).get();
//        loan.setBalance(loanParam.getlBalance());
//        loan.setRemark(loanParam.getlRemark());
//        List<Integer> customerIdList = loanParam.getCidList();
//        List<Customer> customerList = new ArrayList<>();
//        for (Integer customerId : customerIdList) {
//            Customer customer = customerDao.findById(customerId).get();
//            customerList.add(customer);
//        }
//        loan.setCustomer_loan(customerList);
        loanDao.save(loan);
    }

    @Override
    public List<Loan> getAllLoans() {
        List<Loan> loans = (List<Loan>) loanDao.findAll();
        return loans;
    }

    @Override
    public Loan getLoan(int lid) {
        Loan loan = loanDao.findById(lid).get();
        return loan;
    }

    @Override
    public List<Loan> getLoanOfCustomer(int cid) {
        Customer customer = customerDao.findById(cid).get();
        List<Loan> loans = customer.getLoans();
        return loans;
    }
}
