package com.hwj.banking.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "LOAN")
@SequenceGenerator(name = "loan_SG", allocationSize = 1, initialValue = 1, sequenceName = "loan_sg")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loan_SG")
    @Column(name = "lid")
    private int id;

    @Column(name = "lBlance")
    private long balance;

    @Column(name = "lRemark")
    private String remark;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "Loan_Customer", joinColumns = {@JoinColumn(name = "lid")}, inverseJoinColumns = {@JoinColumn(name = "cid")})
    private List<Customer> customer_loan = new ArrayList<>();


    public Loan() {
    }

    public Loan(long balance, String remark, List<Customer> customer_loan) {
        this.balance = balance;
        this.remark = remark;
        this.customer_loan = customer_loan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<Customer> getCustomer_loan() {
        return customer_loan;
    }

    public void setCustomer_loan(List<Customer> customer_loan) {
        this.customer_loan = customer_loan;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", balance=" + balance +
                ", remark='" + remark + '\'' +
                ", customer_loan=" + customer_loan +
                '}';
    }
}
