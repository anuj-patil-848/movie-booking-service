package com.anuj.movie.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anuj.movie.Request.UserRequest;
import com.anuj.movie.Services.UserService;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addNew")
    public ResponseEntity<String> addNewUser(@RequestBody UserRequest userRequest){
        try{
            System.out.println(userRequest);
            String result = userService.addUser(userRequest);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (Exception e){
            System.out.println("hi");
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
