package com.hwj.banking.Service;

import com.hwj.banking.Entity.Customer;
import com.hwj.banking.Param.CustomerParam;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    void addCustomer(CustomerParam customerParam);
    void deleteCustomer(int id);
    void updateCustomer(CustomerParam customerParam);
    Optional<Customer> getCustomer(int id);
    List<Customer> getAllCustomers();
}
