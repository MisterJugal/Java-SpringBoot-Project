package com.StudentAndCourses.ExternalServices;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.StudentAndCourses.Entity.Home;

@FeignClient(name = "HOME-SERVICE/home")
public interface HomeService {

    @GetMapping("/getHomes")
    public ResponseEntity<List<Home>> getAllHomes();

    @GetMapping("/getHomeById/{homeId}")
    public ResponseEntity<Home> getHomeById(@PathVariable int homeId);

    @PostMapping("/addHome")
    public ResponseEntity<Home> addHome(@RequestBody Home home);

    @PostMapping("/addMultipleHomes")
    public ResponseEntity<List<Home>> addMultipleHomes(@RequestBody List<Home> home);

}
