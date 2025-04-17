package com.credentialRoles.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.credentialRoles.entity.MyUser;


@Repository
public interface MyUserRepository extends JpaRepository<MyUser,String>{

    // @Query()
    // public MyUser loadUserByUsername(String username);

    public Optional<MyUser> findByUsername(String username);
}
