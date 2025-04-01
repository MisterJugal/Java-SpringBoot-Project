package com.credentialRoles.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.credentialRoles.Repo.MyUserRepository;
import com.credentialRoles.Service.MyUserService;
import com.credentialRoles.entity.MyUser;

@Service
public class MyUserServiceImpl implements MyUserService{

    @Autowired
    private MyUserRepository myUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<MyUser> getAllUsers() {

        return myUserRepository.findAll();

    }

    @Override
    public MyUser addUser(MyUser myUser) {

        
        System.out.println("insideservice impl");
        myUser.setRole(myUser.getRole().toUpperCase());
        myUser.setPassword(passwordEncoder.encode(myUser.getPassword()));
        
        System.out.println("password encoded");
        System.out.println("saving user");

        return myUserRepository.save(myUser);
    }

}
