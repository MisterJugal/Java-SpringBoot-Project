package com.HomeService.Service;

import java.util.List;

import com.HomeService.Entity.Home;

public interface HomeService {

    public Home getHomeById(int homeId);
    public List<Home> getAllHomes();
    public Home addHome(Home home);
    public List<Home> addMultipleHomes(List<Home> homes);
} 
