package com.hwj.banking.Entity;

import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.*;

@Entity
@Table(name = "CUSTOMER")
@SequenceGenerator(name = "customer_SG", allocationSize = 1, initialValue = 1, sequenceName = "customer_sg")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_SG")
    private int cid;

    private String username;

    private String password;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "customer", fetch = FetchType.LAZY)
    private CustomerDetail customerDetail;

    public Customer() {
    }

    public Customer(String username, String password, CustomerDetail customerDetail) {
        this.username = username;
        this.password = password;
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
