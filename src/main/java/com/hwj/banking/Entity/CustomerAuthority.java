package com.hwj.banking.Entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//@Entity
//@Table(name = "CustomerAuthority")
//@SequenceGenerator(name = "customerAuthority_SG", allocationSize = 1, initialValue = 1, sequenceName = "customerAuthority_sg")
public class CustomerAuthority extends Customer implements UserDetails {
//    private static final long serialVersionUID = 1L;

    public CustomerAuthority(final Customer customer) {
        super(customer);
    }

//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customerAuthority_SG")
//    private int caid;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        System.out.println("test for customer authority get !!!!!!!");
        List<SimpleGrantedAuthority> list=new ArrayList<SimpleGrantedAuthority>();
        list.add(new SimpleGrantedAuthority("ROLE_"+getRole()));
        return list;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }

//    @Override
//    public String getAuthority() {
//        return role;
//    }

//    @ManyToMany(mappedBy = "customerAuthorities")
//    private List<Customer> customers = new ArrayList<>();

//    public List<Customer> getCustomers() {
//        return customers;
//    }
//
//    public void setCustomers(List<Customer> customers) {
//        this.customers = customers;
//    }
}
