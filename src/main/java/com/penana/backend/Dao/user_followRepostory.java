package com.penana.backend.Dao;

import com.penana.backend.Model.user_follow;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface user_followRepostory extends JpaRepository<user_follow, Integer> {
    @Query(value = "select * from user_follow  where user_id = :user_id and followed_id = :followed_id", nativeQuery = true)
    user_follow findByUser_idAndFollowed_id(Integer user_id, Integer followed_id);
}
