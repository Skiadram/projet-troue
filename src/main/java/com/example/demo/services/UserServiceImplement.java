package com.example.demo.services;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public class UserServiceImplement implements UserService {
    @Autowired
    UserRepository userRepository;

    @Transactional
    @Override
    public Iterable<UserEntity> getAllUser() {
        return this.userRepository.findAllUser();
    }

    @Transactional
    @Override
    public Optional<UserEntity> getUserById(int id) {
        return this.userRepository.findById(id);
    }

    @Transactional
    @Override
    public void deleteUserById(int id) {
        this.userRepository.deleteById(id);
    }

    @Transactional
    @Override
    public UserEntity addUser(UserEntity userEntity) {
        return this.userRepository.save(userEntity);
    }

    @Override
    public Iterable<UserEntity> getAlluserParam(List<String> id_adresse, List<String> libelle, List<String> id_concessionaire) {
        if(id_adresse==null && libelle==null && id_concessionaire==null){
            return this.getAllUser();
        }
        return this.userRepository.findAllUserParam(id_adresse, libelle, id_concessionaire);
    }

}
