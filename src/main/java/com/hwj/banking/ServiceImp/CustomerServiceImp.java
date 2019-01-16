package com.hwj.banking.ServiceImp;

import com.hwj.banking.Dao.CustomerDao;
import com.hwj.banking.Entity.Customer;
import com.hwj.banking.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImp implements CustomerService {

    @Autowired
    CustomerDao customerDao;

    @Override
    public void addCustomer(Customer customer) {

    }

    @Override
    public void deleteCustomer(int id) {

    }

    @Override
    public void updateCustomer(Customer customer) {

    }

    @Override
    public Customer getCustomer(int id) {
        return null;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return null;
    }
}
