package com.hwj.banking.Entity;

import javax.persistence.*;

@Entity
@Table(name = "CHECKINGACCOUNT")
@SequenceGenerator(name = "checking_SG", allocationSize = 1, initialValue = 1, sequenceName = "checking_sg")
public class CheckingAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "checking_SG")
    private int id;


    private String info;

    private long balance;

    private Customer customer;

    public CheckingAccount() {
    }

    public CheckingAccount(long balance, Customer customer) {
        this.balance = balance;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
