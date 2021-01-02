package com.example.demo.services.postService;

import java.util.Optional;

import com.example.demo.entity.PostEntity;
import com.example.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public class PostServiceImplement implements PostService{
    @Autowired
    PostRepository postRepository;

    @Transactional
    @Override
    public Iterable<PostEntity> getAllpost() {
        return this.postRepository.findAllpost();
    }

    @Transactional
    @Override
    public Optional<PostEntity> getPostById(int id){
        return this.postRepository.findById(id);
    }

    @Transactional
    @Override
    public Iterable<PostEntity> showPosts(int user_id) {
        return this.postRepository.showPosts(user_id);
    }
}
