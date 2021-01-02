package com.example.demo.services.userService;

import java.util.Optional;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;
import org.springframework.security.core.userdetails.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import static java.util.Collections.emptyList;


@Repository
@Transactional(readOnly = true)
public class UserServiceImplement implements UserService, UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Transactional
    @Override
    public Iterable<UserEntity> getAlluser() {
        return this.userRepository.findAlluser();
    }

    @Transactional
    @Override
    public Optional<UserEntity> getUserById(int id) {
        return this.userRepository.findById(id);
    }


    @Transactional
    @Override
    public UserEntity save(UserEntity user) {
        return this.userRepository.save(user);
    }

    @Transactional
    public void updateUser(UserEntity user){this.userRepository.updateUser(user);}

    @Transactional
    public void addFriends(int person_id, int friend_id){this.userRepository.addFriends(person_id, friend_id);}

    @Transactional
    @Override
    public UserEntity getUserByUserName(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Transactional
    public void deleteRequest(int requester_id, int requested_id){this.userRepository.deleteRequest(requester_id, requested_id);}

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = this.userRepository.findByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(
            user.getUsername(), 
            user.getPassword(),
            emptyList()
        );
    }
}
