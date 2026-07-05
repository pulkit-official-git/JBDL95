package com.example.jbdl95rest.controller;

import com.example.jbdl95rest.dtos.CreateUserRequest;
import com.example.jbdl95rest.dtos.UserCreateResponse;
import com.example.jbdl95rest.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("/user")
public class UserController2 {

    UserService userService;

    public UserController2() {
        this.userService = new UserService();
    }

    @GetMapping("/create")
    public UserCreateResponse createUser(@RequestBody CreateUserRequest createUserRequest){
//        UserService userService = new UserService();
        return userService.createUser(createUserRequest);
    }
}


/*
* we cannot have duplicate apis because dispatched servelet will get confuse as both emndpoints are on same server
* Duplicate :-
* path + mapping
*
* */




