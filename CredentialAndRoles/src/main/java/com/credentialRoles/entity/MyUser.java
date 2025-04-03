package com.credentialRoles.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;



@Data
@Entity
public class MyUser{

    @Id
    private String username;
    private String password;
    private String role;

}
