package com.credentialRoles.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.credentialRoles.entity.MyUser;

@Repository
public interface MyUserRepository extends JpaRepository<MyUser,String>{


}
