package com.example.demo.repository;

import com.example.demo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    @Query(value = "select * from user", nativeQuery = true)
    Iterable<UserEntity> findAllUser();

    @Query(value = "select * from user a where " +
            "(coalesce(:id_user, null)is null OR a.id_user IN (:id_user))" +
            "AND (coalesce(:password, null) is null OR a.password IN (:password))" +
            "AND (coalesce(:nom, null) is null OR a.nom IN (:nom))", nativeQuery = true)
    Iterable<UserEntity> findAllUserParam(@Param("id_user") List<String> id_user,
                                          @Param("password") List<String> password, @Param("nom") List<String> nom);
}
