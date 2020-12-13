package com.example.demo.services;

import com.example.demo.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public Iterable<UserEntity> getAllUser();

    Optional<UserEntity> getUserById(int id);

    void deleteUserById(int id);

    UserEntity addUser(UserEntity userEntity);

    Iterable<UserEntity> getAlluserParam(List<String> id_user, List<String> password, List<String> nom);
}
