package com.galvanize.crudapicheckpoint;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.*;

@RestController
public class UserController {
    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    //Endpoint 1
    @GetMapping("/users")
    public Iterable<User> getAllUsers() {
        return this.repository.findAll();
    }

    //Endpoint 2
    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return this.repository.save(user);
    }

    //Endpoint 3
    @GetMapping("/users/{id}")
    public Optional<User> getOneUser(@PathVariable Long id) {
        return this.repository.findById(id);
    }

    //Endpoint 4
    @PatchMapping("/users/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody Map<String, String> userMap) {
        User updatedUser = this.repository.findById(id).get();

        userMap.forEach((key, value) -> {
            if (key.equals("email")) {
                updatedUser.setEmail(value);
            } else if (key.equals("password")) {
                updatedUser.setPassword(value);
            }
        });
        return this.repository.save(updatedUser);
    }

    //Endpoint 5
    @DeleteMapping("/users/{id}")
    public Map<String, Long> deleteUser (@PathVariable Long id){
        Map<String, Long> userMap = new HashMap<>();
        repository.deleteById(id);
        long count = repository.count();
        userMap.put("count", count);
        return userMap;
    }

    //Endpoint 6
    @PostMapping("/users/authenticate")
    public AuthenticateUser authenticate(@RequestBody UserQuery userQuery){
        AuthenticateUser authenticateUser = new AuthenticateUser();
        authenticateUser = null;
        ArrayList<User> userList = (ArrayList<User>) repository.findAll();

        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getEmail().equals(userQuery.getEmail())) {
                if (userList.get(i).getPassword().equals(userQuery.getPassword())) {
                    authenticateUser = new AuthenticateUser(true, userList.get(i));
                }
            }
        }


        if(authenticateUser == null) {
            authenticateUser = new AuthenticateUser(false);
        }

        return authenticateUser;
    }


    @ExceptionHandler({NoSuchElementException.class, EmptyResultDataAccessException.class})
    public ResponseEntity<String> catchNoSuchElementException() {
        return new ResponseEntity<>("does not exist", HttpStatus.NOT_FOUND);
    }


}

