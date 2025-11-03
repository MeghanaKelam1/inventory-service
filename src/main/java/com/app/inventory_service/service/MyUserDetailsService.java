package com.app.inventory_service.service;

import com.app.inventory_service.model.UserPrinciple;
import com.app.inventory_service.model.Users;
import com.app.inventory_service.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UsersRepo  repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = repo.findUserByUsername(username);
        System.out.println("Looking for user: "+username);
        if(user == null){
            System.out.println("user not found");
            throw new UsernameNotFoundException("user not found");
        }
        Users users = repo.findUserByUsername("megha");
        System.out.println("User found: " + users);
        return new UserPrinciple(user);

    }
}
