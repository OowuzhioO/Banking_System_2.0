package com.hwj.banking.Entity;

import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.*;

@Entity
@RequestMapping("/customerDetail")
public class CustomerDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "cdid")
    private int id;

    private int age;

    private String Email;

    private String phone;

    private String remark;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cid")
    private Customer customer;

    public CustomerDetail() {
    }

    public CustomerDetail(String email, String phone, String remark) {
        Email = email;
        this.phone = phone;
        this.remark = remark;
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
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
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
}
