package com.hwj.banking.Dao;

import com.hwj.banking.Entity.CheckingAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckingAccountDao extends CrudRepository <CheckingAccount, Integer>{
}
