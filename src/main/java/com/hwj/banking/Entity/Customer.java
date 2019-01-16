package com.hwj.banking.Entity;

import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.*;

@Entity
@RequestMapping("/customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int cid;

    private String username;

    private String password;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "customer", fetch = FetchType.LAZY)
    private CustomerDetail customerDetail;

    public Customer() {
    }

    public Customer(String username, String passord, CustomerDetail customerDetail) {
        this.username = username;
        this.password = passord;
        this.customerDetail = customerDetail;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassord() {
        return password;
    }

    public void setPassord(String passord) {
        this.password = passord;
    }

    public CustomerDetail getCustomerDetail() {
        return customerDetail;
    }

    public void setCustomerDetail(CustomerDetail customerDetail) {
        this.customerDetail = customerDetail;
    }
}
