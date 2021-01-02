package com.example.demo.controller;

import com.example.demo.entity.PostEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.services.postService.PostService;
import com.example.demo.services.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@BasePathAwareController
public class PostController {

    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;

    @GetMapping("/posts/show")
    public @ResponseBody Iterable<PostEntity> showPost(){
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserEntity userLogged = userService.getUserByUserName(username);
        int user_id = userLogged.getUserId();
        return this.postService.showPosts(user_id);
    }
}
