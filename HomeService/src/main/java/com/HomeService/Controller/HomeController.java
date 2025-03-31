package com.HomeService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HomeService.Entity.Home;
import com.HomeService.Service.HomeService;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private HomeService homeService;

    @GetMapping("/getHomes")
    public ResponseEntity<List<Home>> getAllHomes()
    {

        return new ResponseEntity<>(homeService.getAllHomes(),HttpStatus.OK);
    }

    @GetMapping("/getHomeById/{homeId}")
    public ResponseEntity<Home> getHomeById(@PathVariable int homeId)
    {

        return new ResponseEntity<>(homeService.getHomeById(homeId),HttpStatus.OK);
    }
    
    @PostMapping("/addHome")
    public ResponseEntity<Home> addHome(@RequestBody Home home)
    {
        
        return new ResponseEntity<>(homeService.addHome(home),HttpStatus.CREATED);
    }

    @PostMapping("/addMultipleHomes")
    public ResponseEntity<List<Home>> addMultipleHomes(@RequestBody List<Home> home)
    {

       
        return new ResponseEntity<>( homeService.addMultipleHomes(home),HttpStatus.CREATED);
    }

}
