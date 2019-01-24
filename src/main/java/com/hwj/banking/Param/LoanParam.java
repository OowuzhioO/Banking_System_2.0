package com.hwj.banking.Param;

import java.util.List;

public class LoanParam {

    private Integer lid;

    private Long lBalance;

    private String lRemark;

    private Integer cid;

    private List<Integer> cidList;

    public LoanParam() {
    }

    public LoanParam(Integer lid, Long lBalance, String lRemark, Integer cid, List<Integer> cidList) {
        this.lid = lid;
        this.lBalance = lBalance;
        this.lRemark = lRemark;
        this.cid = cid;
        this.cidList = cidList;
    }

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public Long getlBalance() {
        return lBalance;
    }

    public void setlBalance(Long lBalance) {
        this.lBalance = lBalance;
    }

    public String getlRemark() {
        return lRemark;
    }

    public void setlRemark(String lRemark) {
        this.lRemark = lRemark;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public List<Integer> getCidList() {
        return cidList;
    }

    public void setCidList(List<Integer> cidList) {
        this.cidList = cidList;
    }

    @Override
    public String toString() {
        return "LoanParam{" +
                "lid=" + lid +
                ", lBalance=" + lBalance +
                ", lRemark='" + lRemark + '\'' +
                ", cid=" + cid +
                ", cidList=" + cidList +
                '}';
    }
}
