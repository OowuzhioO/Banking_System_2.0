package com.hwj.banking.Service;

import com.hwj.banking.Entity.Customer;
import com.hwj.banking.Entity.CustomerDetail;

import java.util.List;

public interface CustomerDetailService {
    void addCustomerDetail();
    void deleteCustomerDetail(int id);
    void updateCustomerDetail(CustomerDetail customerDetail);
    CustomerDetail getCustomerDetail(int id);
    List<CustomerDetail> getAllCustomerDetails();
}
