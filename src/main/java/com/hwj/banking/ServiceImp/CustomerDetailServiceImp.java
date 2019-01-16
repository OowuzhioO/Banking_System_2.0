package com.hwj.banking.ServiceImp;

import com.hwj.banking.Dao.CustomerDetailDao;
import com.hwj.banking.Entity.CustomerDetail;
import com.hwj.banking.Service.CustomerDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerDetailServiceImp implements CustomerDetailService {

    @Autowired
    CustomerDetailDao customerDetailDao;

    @Override
    public void addCustomerDetail() {

    }

    @Override
    public void deleteCustomerDetail(int id) {

    }

    @Override
    public void updateCustomerDetail(CustomerDetail customerDetail) {

    }

    @Override
    public CustomerDetail getCustomerDetail(int id) {
        return null;
    }

    @Override
    public List<CustomerDetail> getAllCustomerDetails() {
        return null;
    }
}
