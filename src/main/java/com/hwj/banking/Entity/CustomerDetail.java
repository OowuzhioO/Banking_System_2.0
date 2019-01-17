package com.hwj.banking.Entity;

import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.*;

@Entity
@Table(name = "CUSTOMERDETAIL")
@SequenceGenerator(name = "customerDetail_SG", allocationSize = 1, initialValue = 1, sequenceName = "customerDetail_sg")
public class CustomerDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customerDetail_SG")
    @Column(name = "cdid")
    private int id;

    private int age;

    private String email;

    private String phone;

    private String remark;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cid")
    private Customer customer;

    public CustomerDetail() {
    }

    public CustomerDetail(String email, String phone, String remark, Customer customer) {
        this.email = email;
        this.phone = phone;
        this.remark = remark;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
