package com.hwj.banking.Dao;

import com.hwj.banking.Entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerDao extends CrudRepository<Customer, Integer> {
    Optional<Customer> findByUsername(String username);
}
