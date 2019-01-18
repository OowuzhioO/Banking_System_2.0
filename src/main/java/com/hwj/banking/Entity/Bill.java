package com.hwj.banking.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "BILL")
@SequenceGenerator(name = "bill_SG", allocationSize = 1, initialValue = 1, sequenceName = "bill_sg")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bill_SG")
    private int id;

    private Date date;

    private String info;

    private long balance;

//    @OneToOne(cascade = CascadeType.ALL, mappedBy = "customer", fetch = FetchType.LAZY)
    @ManyToOne
    @JoinColumn(name = "cid")
    private Customer customer;

    public Bill() {
    }

    public Bill(Date date, String info, long balance, Customer customer) {
        this.date = date;
        this.info = info;
        this.balance = balance;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
