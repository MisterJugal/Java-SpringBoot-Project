package com.credentialRoles.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credentialRoles.Repo.MyUserRepository;
import com.credentialRoles.Service.MyUserService;
import com.credentialRoles.entity.MyUser;

@Service
public class MyUserServiceImpl implements MyUserService{

    @Autowired
    private MyUserRepository myUserRepository;

    @Override
    public List<MyUser> getAllUsers() {

        return myUserRepository.findAll();

    }

    @Override
    public MyUser addUser(MyUser myUser) {

        myUser.setRole(myUser.getRole().toUpperCase());

        return myUserRepository.save(myUser);
    }

}
