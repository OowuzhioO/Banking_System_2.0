package com.hwj.banking.Dao;

import com.hwj.banking.Entity.Loan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanDao extends CrudRepository <Loan, Integer> {
}
