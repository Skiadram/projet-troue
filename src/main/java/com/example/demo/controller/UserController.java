package com.example.demo.controller;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import com.example.demo.entity.UserEntity;
import com.example.demo.services.userService.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@BasePathAwareController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/users")
    public ResponseEntity redirectSignUp() throws URISyntaxException {
        HttpHeaders headers = new HttpHeaders();
        if(System.getenv("PROD_URL") != null) {
            headers.setLocation(new URI(System.getenv("PROD_URL") + "/users/sign-up"));
        
        } else headers.setLocation(new URI("http://localhost:8080/users/sign-up"));

        return new ResponseEntity<>(headers, HttpStatus.TEMPORARY_REDIRECT);
    }

    @PostMapping("/users/sign-up")
    public ResponseEntity signUp(@RequestBody UserEntity user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userService.save(user);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @PostMapping("/users/{requester_id}/requestFriend")
    public ResponseEntity requestFriend(@PathVariable("requester_id") int requester_id, @RequestBody int requested_id){
        System.out.println(requested_id);
        UserEntity requested = userService.getUserById(requested_id).get();
        userService.getUserById(requester_id)
                .map(requester -> {
                            List list1 = requester.getRequestTo();
                            list1.add(requested);
                            requester.setRequestTo(list1);
                            return userService.save(requester);
                        }
                );

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("/users/{requested_id}/accept/{requester_id}")
    public ResponseEntity acceptRequest(@PathVariable("requested_id") int requested_id, @PathVariable("requester_id") int requester_id){
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserEntity accepter = userService.getUserByUserName(username);
        UserEntity requester = userService.getUserById(requester_id).get();

        userService.addFriends(requested_id, requester_id);
        userService.addFriends(requester_id, requested_id);
        userService.deleteRequest(requester_id, requested_id);

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("/users/{requested_id}/deny/{requester_id}")
    public ResponseEntity denyRequest(@PathVariable("requested_id") int requested_id, @PathVariable("requester_id") int requester_id){
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserEntity accepter = userService.getUserByUserName(username);
        UserEntity requester = userService.getUserById(requester_id).get();

        userService.deleteRequest(requester_id, requested_id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}