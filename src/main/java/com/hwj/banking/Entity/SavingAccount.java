package com.hwj.banking.Entity;

import javax.persistence.*;

@Entity
@Table(name = "SAVINGACCOUNT")
@SequenceGenerator(name = "saving_SG", allocationSize = 1, initialValue = 1, sequenceName = "saving_sg")
public class SavingAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "saving_SG")
    private int id;

    private String info;

    private long balance;

    private Customer customer;

    public SavingAccount() {
    }

    public SavingAccount(String info, long balance, Customer customer) {
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
