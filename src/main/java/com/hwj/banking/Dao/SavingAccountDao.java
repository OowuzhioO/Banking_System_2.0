package com.hwj.banking.Dao;

import com.hwj.banking.Entity.SavingAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingAccountDao extends CrudRepository <SavingAccount, Integer>{
}
