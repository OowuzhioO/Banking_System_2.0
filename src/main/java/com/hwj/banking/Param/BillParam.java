package com.hwj.banking.Param;

import java.util.Date;

public class BillParam {

    private Integer bid;

    private Date datetime;

    private String billInfo;

    private Integer billBalance;

    private Integer cid;

    public BillParam() {
    }

    public BillParam(Date datetime, String billInfo, Integer billBalance, Integer cid) {
        this.datetime = datetime;
        this.billInfo = billInfo;
        this.billBalance = billBalance;
        this.cid = cid;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
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

    public Integer getBillBalance() {
        return billBalance;
    }

    public void setBillBalance(Integer billBalance) {
        this.billBalance = billBalance;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }
}
