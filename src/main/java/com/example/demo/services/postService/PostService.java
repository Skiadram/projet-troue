package com.example.demo.services.postService;

import java.util.Optional;

import com.example.demo.entity.PostEntity;

public interface PostService {

    public Iterable<PostEntity>getAllpost();

    Optional<PostEntity> getPostById(int id);

    Iterable<PostEntity>showPosts(int user_id);
}
