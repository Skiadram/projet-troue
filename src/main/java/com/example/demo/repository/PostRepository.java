package com.example.demo.repository;

import com.example.demo.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(path="posts")
public interface PostRepository extends JpaRepository<PostEntity, Integer> {

    @Query(value = "select * from Post", nativeQuery = true)
    Iterable<PostEntity> findAllpost();


    @Query(value = "select distinct p.post_id, p.text, p.user_id, p.private_post from post p join friend f where " +
            "(p.user_id = f.person_id AND p.post_id IN ( select distinct p2.post_id from post p2 where p2.user_id = ?1 OR f.friend_id = ?1))" +
            " OR p.private_post = 0 ", nativeQuery = true)
    Iterable<PostEntity>showPosts(int user_id);
}
