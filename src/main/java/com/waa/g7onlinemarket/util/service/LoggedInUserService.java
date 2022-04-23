package com.waa.g7onlinemarket.util.service;

import com.waa.g7onlinemarket.models.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class LoggedInUserService {

    public static User user = null;

    public long getUserId(){
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//
//        User user = (User) auth.getPrincipal();
            return user.getId();
    }

    public User getLoggedInUser()
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        User user = (User) auth.getPrincipal();
        System.out.println(user);

        return user;
    }
}
