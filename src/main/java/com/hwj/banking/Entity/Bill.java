package com.hwj.banking.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "BILL")
@SequenceGenerator(name = "bill_SG", allocationSize = 1, initialValue = 1, sequenceName = "bill_sg")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bill_SG")
    @Column(name = "bid")
    private int bid;

//    @CreationTimestamp
//    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date datetime;

    private String billInfo;

    private int billBalance;

    @ManyToOne
    @JoinColumn(name = "cid")
    @JsonIgnore
    private Customer customer_bill;

    public Bill() {
    }

    public Bill(Date datetime, String billInfo, int billBalance, Customer customer_bill) {
        this.datetime = datetime;
        this.billInfo = billInfo;
        this.billBalance = billBalance;
        this.customer_bill = customer_bill;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getBillInfo() {
        return billInfo;
    }

    public void setBillInfo(String billInfo) {
        this.billInfo = billInfo;
    }

    public int getBillBalance() {
        return billBalance;
    }

    public void setBillBalance(int billBalance) {
        this.billBalance = billBalance;
    }

    public Customer getCustomer_bill() {
        return customer_bill;
    }

    public void setCustomer_bill(Customer customer_bill) {
        this.customer_bill = customer_bill;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "bid=" + bid +
                ", datetime=" + datetime +
                ", billInfo='" + billInfo + '\'' +
                ", billBalance=" + billBalance +
                ", customer_bill=" + customer_bill +
                '}';
    }
}
