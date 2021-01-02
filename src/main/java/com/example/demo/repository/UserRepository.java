package com.example.demo.repository;

import java.util.Optional;

import com.example.demo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(path="users")
public interface UserRepository extends CrudRepository<UserEntity, Integer> {

    @Query(value = "select * from User", nativeQuery = true)
    Iterable<UserEntity> findAlluser();

    @Query(value = "select * from User where User.username=?1", nativeQuery=true)
    UserEntity findByUsername(String username);

    @Modifying
    @Query(value = "update User u set u=?1", nativeQuery=true)
    void updateUser(UserEntity u);

    @Modifying
    @Query(value = "insert into Friend (person_id, friend_id) values (?1, ?2)", nativeQuery=true)
    void addFriends(int person_id, int friend_id);

    @Modifying
    @Query(value = "DELETE from request where requester_id=?1 AND requested_id=?2", nativeQuery=true)
    void deleteRequest(int requester_id, int requested_id);
}
