package com.example.demo.services.userService;

import java.util.Optional;

import com.example.demo.entity.UserEntity;

public interface UserService {

    public Iterable<UserEntity>getAlluser();

    Optional<UserEntity> getUserById(int id);

    public UserEntity save(UserEntity user);

     UserEntity getUserByUserName(String username);

     public void updateUser(UserEntity user);

     public void addFriends(int person_id, int friend_id);

     public void deleteRequest(int requester_id, int requested_id);
}
