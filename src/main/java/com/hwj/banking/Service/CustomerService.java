package com.hwj.banking.Service;

import com.hwj.banking.Entity.Customer;

import java.util.List;

public interface CustomerService {
    void addCustomer(Customer customer);
    void deleteCustomer(int id);
    void updateCustomer(Customer customer);
    Customer getCustomer(int id);
    List<Customer> getAllCustomers();
}
