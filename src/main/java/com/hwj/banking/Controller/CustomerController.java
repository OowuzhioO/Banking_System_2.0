package com.hwj.banking.Controller;


import com.hwj.banking.Entity.Customer;
import com.hwj.banking.Entity.CustomerDetail;
import com.hwj.banking.Param.CustomerParam;
import com.hwj.banking.Service.CustomerDetailService;
import com.hwj.banking.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerDetailService customerDetailService;

    @GetMapping("/queryAllCustomersInfo")
    public String queryAllCustomersInfo() {
        List<Customer> customers = customerService.getAllCustomers();
        for (Customer customer : customers) {
            CustomerDetail customerDetail = customer.getCustomerDetail();
            CustomerParam customerParam = new CustomerParam(customer, customerDetail);
            System.out.println(customerParam);
        }
        return "query all customers info successfully!";
    }

    @GetMapping("/queryCustomerInfo/{id}")
    public String queryCustomerInfo(@PathVariable int id){
        Customer customer = customerService.getCustomer(id).get();
        CustomerDetail customerDetail = customer.getCustomerDetail();
        CustomerParam customerParam = new CustomerParam(customer, customerDetail);
        System.out.println(customerParam);
        return "query customer info successfully";
    }

    @PostMapping("/addCustomerInfo")
    public String addCustomerInfo(@RequestBody CustomerParam customerParam){
        System.out.println(customerParam);
        customerService.addCustomer(customerParam);
        return "add customer successfully";
    }

    @GetMapping("/deleteCustomerInfo/{id}")
    public String deleteCustomerInfo(@PathVariable int id) {
        customerService.deleteCustomer(id);
        return "delete customer info successfully";
    }

    @PutMapping("/updateCustomerInfo")
    public String updateCustomerInfo(@RequestBody CustomerParam customerParam) {
        System.out.println("update customer info:" + customerParam.getCid());
        System.out.println("update customer info:" + customerParam.getPassword());
        customerService.updateCustomer(customerParam);
        return "update customer info successfully";
    }
}
