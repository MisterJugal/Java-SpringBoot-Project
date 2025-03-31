package com.HomeService.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.HomeService.Entity.Home;
import com.HomeService.Repository.HomeRepo;
import com.HomeService.Service.HomeService;

@Component
@Service
public class HomeServiceImpl implements HomeService{

    @Autowired
    private HomeRepo homeRepo;

    @Override
    public Home getHomeById(int homeId) {

        Optional<Home> op= homeRepo.findById(homeId);
        try{
            
        return op.get();
        }

        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }

        
    }

    @Override
    public List<Home> getAllHomes() {
       return homeRepo.findAll();
    }

    @Override
    public Home addHome(Home home) {
        
        return homeRepo.save(home);
    }

    @Override
    public List<Home> addMultipleHomes(List<Home> homes) {
        
        for(Home h:homes)
            homeRepo.save(h);
        

        return homes;
    }


}
