package com.hwj.banking.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hwj.banking.Config.CrypConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "CUSTOMER")
@SequenceGenerator(name = "customer_SG", allocationSize = 1, initialValue = 1, sequenceName = "customer_sg")
public class Customer {

//    @Autowired
//    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_SG")
    private int cid;

    @Column(name = "cUsername")
    private String username;

    @Column(name = "cPassword")
    private String password;

//    @Column(name = "role")
    private String role;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "customer", fetch = FetchType.LAZY)
    @JsonIgnore
    private CustomerDetail customerDetail;

    @OneToMany(cascade = {
            CascadeType.REMOVE,
            CascadeType.MERGE
    }, mappedBy = "customer_bill", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Bill> bill = new ArrayList<>();

    @ManyToMany(cascade = {
            CascadeType.MERGE,
            CascadeType.REMOVE
    }, mappedBy = "customer_loan", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Loan> loans = new ArrayList<>();


//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinTable(name = "sys_customer_authority", joinColumns = {@JoinColumn(name = "cutomer_id", referencedColumnName = "cid")},
//    inverseJoinColumns = {@JoinColumn(name = "customerAuthority_id", referencedColumnName = "caid")})
//    private List<CustomerAuthority> customerAuthorities = new ArrayList<>();



    public Customer() {
        this.role = "user";
    }

//    public Customer(String username, String password, CustomerDetail customerDetail, List<Bill> bill, List<Loan> loans) {
//        this.username = username;
//        this.password = password;
//        this.customerDetail = customerDetail;
//        this.bill = bill;
//        this.loans = loans;
//    }


    public Customer(String username, String password, String role, CustomerDetail customerDetail, List<Bill> bill, List<Loan> loans, List<CustomerAuthority> customerAuthorities) {
        this.username = username;
        this.password = password;
//        this.role = role;
        this.customerDetail = customerDetail;
        this.bill = bill;
        this.loans = loans;
//        this.customerAuthorities = customerAuthorities;
    }

    public Customer(Customer customer) {
        this.username = customer.getUsername();
        this.password = customer.getPassword();
//        this.role = customer.getRole();
        this.customerDetail = customer.getCustomerDetail();
        this.bill = customer.getBill();
        this.loans = customer.getLoans();
//        this.customerAuthorities = customer.getCustomerAuthorities();
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getUsername() {
        return username;
    }

//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }

    public void setUsername(String username) {
        this.username = username;
    }

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<SimpleGrantedAuthority> simpleAuthorities = new ArrayList<>();
//        for(GrantedAuthority authority : this.customerAuthorities){
//            simpleAuthorities.add(new SimpleGrantedAuthority(authority.getAuthority()));
//        }
//        System.out.println("simplue authoriteis has more ; " + simpleAuthorities);
//        return simpleAuthorities;
//    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
//        this.password = bCryptPasswordEncoder.encode(password);
        this.password = password;
    }

    public CustomerDetail getCustomerDetail() {
        return customerDetail;
    }

    public void setCustomerDetail(CustomerDetail customerDetail) {
        this.customerDetail = customerDetail;
    }

    public List<Bill> getBill() {
        return bill;
    }

    public void setBill(List<Bill> bill) {
        this.bill = bill;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

//    public List<CustomerAuthority> getCustomerAuthorities() {
//        return customerAuthorities;
//    }
//
//    public void setCustomerAuthorities(List<CustomerAuthority> customerAuthorities) {
//        this.customerAuthorities = customerAuthorities;
//    }

    @Override
    public String toString() {
        return "Customer{" +
                "cid=" + cid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", customerDetail=" + customerDetail +
                ", bill=" + bill +
                ", loans=" + loans +
                '}';
    }
}
