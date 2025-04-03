package com.credentialRoles.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.*;

import com.credentialRoles.Service.MyUserService;
import com.credentialRoles.entity.MyUser;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/admin")
public class MyUserController {

    @Autowired
    private MyUserService myUserService;

    @GetMapping("/allUsers")
    public ResponseEntity<List<MyUser>> getAllUsers()
    {  System.out.println("Going to service impl to get user");
        return new ResponseEntity<>( myUserService.getAllUsers(),HttpStatus.OK );
    }


    @PostMapping("/addUser")
    public ResponseEntity<MyUser> addUser(@RequestBody MyUser myUser) {
        
        System.out.println("Going to service impl to add user");
        return new ResponseEntity<>(myUserService.addUser(myUser),HttpStatus.CREATED);
    }

    @GetMapping("/loginSuccess")
    public String getMethodName() {
        return new String("Login success");
    }
    
    
    

}
