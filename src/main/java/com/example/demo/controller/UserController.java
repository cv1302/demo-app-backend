package com.example.demo.controller;

import com.example.demo.entities.UserEntity;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Get all user
     *
     * @return List of UserEntity
     */
    @GetMapping
    public ResponseEntity<List<UserEntity>> getAllUser() {
        List<UserEntity> userList = userService.getAllUser();
        if (userList != null) {
            return new ResponseEntity<>(userList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Create new user
     *
     * @param userEntity UserEntity
     * @return void
     */
    @PostMapping
    public ResponseEntity<Void> addUser(@RequestBody UserEntity userEntity) {
        userService.saveUser(userEntity);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
