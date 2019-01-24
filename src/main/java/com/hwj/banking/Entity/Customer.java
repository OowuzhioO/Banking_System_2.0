package com.hwj.banking.Entity;

import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CUSTOMER")
@SequenceGenerator(name = "customer_SG", allocationSize = 1, initialValue = 1, sequenceName = "customer_sg")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_SG")
    private int cid;

    @Column(name = "cUsername")
    private String username;

    @Column(name = "cPassword")
    private String password;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "customer", fetch = FetchType.LAZY)
    private CustomerDetail customerDetail;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer_bill", fetch = FetchType.LAZY)
    private List<Bill> bill = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "customer_loan", fetch = FetchType.LAZY)
    private List<Loan> loans = new ArrayList<>();



    public Customer() {
    }

    public Customer(String username, String password, CustomerDetail customerDetail, List<Bill> bill, List<Loan> loans) {
        this.username = username;
        this.password = password;
        this.customerDetail = customerDetail;
        this.bill = bill;
        this.loans = loans;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public CustomerDetail getCustomerDetail() {
        return customerDetail;
    }

    public void setCustomerDetail(CustomerDetail customerDetail) {
        this.customerDetail = customerDetail;
    }

    public List<Bill> getBill() {
        return bill;
    }

    public void setBill(List<Bill> bill) {
        this.bill = bill;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cid=" + cid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", customerDetail=" + customerDetail +
                ", bill=" + bill +
                ", loans=" + loans +
                '}';
    }
}
