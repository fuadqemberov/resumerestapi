package com.company.service;


import com.company.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
private UserServiceInter repo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User u = repo.getByEmail(email);

        if(u != null){

            UserBuilder ub = org.springframework.security.core.userdetails.User.withUsername(email);
            ub.disabled(false);
            ub.password(u.getPassword());



            String[] author =  new String[] {"ADMIN","ROLE_ADMIN",};
            ub.authorities(author);

            return ub.build();
        }
        else{
            throw new UsernameNotFoundException("User not found");
        }
    }
}
