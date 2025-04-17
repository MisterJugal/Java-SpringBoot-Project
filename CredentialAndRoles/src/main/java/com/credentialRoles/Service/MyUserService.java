package com.credentialRoles.Service;

import java.util.List;


import com.credentialRoles.entity.MyUser;

public interface MyUserService {

   List<MyUser> getAllUsers();
   MyUser addUser(MyUser myUser);
   MyUser loadUserByUsername(String username);
}
