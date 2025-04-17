package com.SchoolDetails.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.SchoolDetails.GlobalExceptionHandler.ResourceNotFoundException;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private RestTemplate restTemplate;

    @SuppressWarnings("null")
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String url = "http://localhost:5000/admin/loadUser/" + username;

        try{
            MyUser user = restTemplate.getForEntity(url, MyUser.class).getBody();
            if (user.equals(null))
            throw new ResourceNotFoundException("This user does not exist in our data base.................");

        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole())
                .build();

        }
       catch(Exception e)
       {
        System.out.println("May be the Credential service is down..........................");
        e.printStackTrace();
        return null;
       }
        
    }

}
