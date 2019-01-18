package com.hwj.banking.Param;

import com.hwj.banking.Entity.Customer;
import com.hwj.banking.Entity.CustomerDetail;

public class CustomerParam {

    private Integer cid;

    private String username;

    private String password;

    private Integer age;

    private String email;

    private String phone;

    private String remark;


    public CustomerParam() {
    }


    public CustomerParam(String username, String password, int age, String email, String phone, String remark) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.remark = remark;
    }

    public CustomerParam(Customer customer, CustomerDetail customerDetail) {
        this.cid = customer.getCid();
        this.username = customer.getUsername();
        this.password = customer.getPassword();
        this.age = customerDetail.getAge();
        this.email = customerDetail.getEmail();
        this.phone = customerDetail.getPhone();
        this.remark = customerDetail.getRemark();
    }

    @Override
    public String toString() {
        return "CustomerParam{" +
                "cid=" + cid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", Email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }

    public Customer getCustomer(){
        Customer customer = new Customer();
//        customer.setCid(this.cid);
        customer.setUsername(this.username);
        customer.setPassword(this.password);
        return customer;
    }

    public CustomerDetail getCustomerDetail() {
        CustomerDetail customerDetail = new CustomerDetail();
//        customerDetail.setId(this.cid);
        customerDetail.setAge(this.age);
        customerDetail.setEmail(this.email);
        customerDetail.setPhone(this.phone);
        customerDetail.setRemark(this.remark);
        return customerDetail;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
