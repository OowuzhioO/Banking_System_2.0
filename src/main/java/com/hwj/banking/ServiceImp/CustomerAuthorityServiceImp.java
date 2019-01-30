package com.hwj.banking.ServiceImp;

import com.hwj.banking.Dao.CustomerDao;
import com.hwj.banking.Entity.Customer;
import com.hwj.banking.Entity.CustomerAuthority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerAuthorityServiceImp implements UserDetailsService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("load username !!!!!!!!!!!!!!!!");
        Optional<Customer> optionalUser=customerDao.findByUsername(username);
        optionalUser.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        return optionalUser.map(CustomerAuthority::new).get();
    }
}
