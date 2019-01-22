package com.hwj.banking.Dao;

import com.hwj.banking.Entity.Bill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillDao extends CrudRepository <Bill, Integer>{
}
