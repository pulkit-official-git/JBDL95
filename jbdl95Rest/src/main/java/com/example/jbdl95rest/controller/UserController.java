package com.example.jbdl95rest.controller;

import com.example.jbdl95rest.dtos.CreateUserRequest;
import com.example.jbdl95rest.dtos.GetUserResponse;
import com.example.jbdl95rest.dtos.UpdateUserRequest;
import com.example.jbdl95rest.dtos.UserCreateResponse;
import com.example.jbdl95rest.exception.UserNotFoundException;
import com.example.jbdl95rest.model.User;
import com.example.jbdl95rest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    public UserController() {
//        this.userService = new UserService();
    }

//    @PostMapping("/create")
//    public UserCreateResponse createUser(@RequestBody CreateUserRequest createUserRequest){
////        UserService userService = new UserService();
//        return userService.createUser(createUserRequest);
//    }

    @PostMapping("/create")
    public UserCreateResponse createUser2(@RequestBody CreateUserRequest createUserRequest){
//        UserService userService = new UserService();
        return userService.createUser(createUserRequest);
    }

    @GetMapping("/get")
    public ResponseEntity<GetUserResponse> getUser(@RequestParam Integer id){
//        UserService userService = new UserService();
        GetUserResponse getUserResponse =  userService.getUser(id);

        return new ResponseEntity<>(getUserResponse,HttpStatus.ACCEPTED);
    }
//    localhost:8080/user/get?id=123&name="ram"
//    more readable

    @GetMapping("/get/id/{id}")
    public GetUserResponse getUser2(@PathVariable("id") Integer id){
//        UserService userService = new UserService();
        return userService.getUser(id);
    }

    //    localhost:8080/user/get/id/123/name/"ram"
//    more secure


    @PatchMapping("/patch")
    public User patchUser(@RequestParam Integer id,
                          @RequestBody UpdateUserRequest updateUserRequest){
        return userService.patch2(id,updateUserRequest.toModel());

    }

    @PutMapping("/put")
    public User putUser(@RequestParam Integer id,
                        @RequestBody UpdateUserRequest updateUserRequest){
        return userService.putUser(id,updateUserRequest.toModel());

    }

//    @DeleteMapping("/delete")
//    public User delete(@RequestParam Integer id){
//        return this.userService.delete(id);
//    }


    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam Integer id){
        try {
             this.userService.delete(id);
             return new ResponseEntity<>(HttpStatus.OK);
        }catch (UserNotFoundException ue){
            return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .body("user not found");
        }catch (Exception e ){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getStackTrace());
        }

    }





}
