package com.hwj.banking.Param;

import com.hwj.banking.Entity.Bill;

import java.util.Date;

public class BillParam {

    private Integer id;

    private Date date;

    private String info;

    private Long balance;

    private Integer cid;

    public BillParam() {
    }

    public BillParam(Date date, String info, Long balance, Integer cid) {
        this.date = date;
        this.info = info;
        this.balance = balance;
        this.cid = cid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

}
