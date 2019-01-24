package com.hwj.banking.ServiceImp;

import com.hwj.banking.Dao.CustomerDao;
import com.hwj.banking.Dao.CustomerDetailDao;
import com.hwj.banking.Entity.Customer;
import com.hwj.banking.Entity.CustomerDetail;
import com.hwj.banking.Param.CustomerParam;
import com.hwj.banking.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImp implements CustomerService {

    @Autowired
    CustomerDao customerDao;

    @Autowired
    CustomerDetailDao customerDetailDao;

    @Override
    public void addCustomer(CustomerParam customerParam) {
        Customer customer = customerParam.getCustomer();
        CustomerDetail customerDetail = customerParam.getCustomerDetail();
        customer.setCustomerDetail(customerDetail);
        customerDetail.setCustomer(customer);
        customerDao.save(customer);
    }

    @Override
    public void deleteCustomer(int id) {
        customerDao.deleteById(id);
    }

    @Override
    public void updateCustomer(CustomerParam customerParam) {
        int targetCid = customerParam.getCid();

        Customer customer = customerDao.findById(targetCid).get();
        customer.setCid(customerParam.getCid());
        customer.setUsername(customerParam.getUsername());
        customer.setPassword(customerParam.getPassword());

        int targetCdid = customer.getCustomerDetail().getId();
        CustomerDetail customerDetail = customerDetailDao.findById(targetCdid).get();
        customerDetail.setAge(customerParam.getAge());
        customerDetail.setEmail(customerParam.getEmail());
        customerDetail.setPhone(customerParam.getPhone());
        customerDetail.setRemark(customerParam.getRemark());
        customer.setCustomerDetail(customerDetail);
        customerDetail.setCustomer(customer);

        customerDao.save(customer);
    }

    @Override
    public Optional<Customer> getCustomer(int id) {

        System.out.println("customer id is : " + id);

        return customerDao.findById(id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return (List<Customer>) customerDao.findAll();
    }
}
