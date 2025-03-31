package com.HomeService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HomeService.Entity.Home;

@Repository
public interface HomeRepo extends JpaRepository<Home,Integer>{

    
} 
