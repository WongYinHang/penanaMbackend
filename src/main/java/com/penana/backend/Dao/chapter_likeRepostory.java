package com.penana.backend.Dao;

import java.util.List;

import com.penana.backend.Model.chapter_like;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface chapter_likeRepostory extends JpaRepository<chapter_like, Integer> {
    @Query(value = "select new com.penana.backend.Model.chapter_like(c.chapter_id as chapter_id, c.id as id, c.user_id as user_id, c.mark_deleted as mark_deleted) from chapter_like c  where c.user_id = :user_id")
    List<Object> findByuser_id(Integer user_id);

    @Query(value = "select new com.penana.backend.Model.chapter_like(c.chapter_id as chapter_id, c.id as id, c.user_id as user_id, c.mark_deleted as mark_deleted) from chapter_like c  where c.chapter_id = :chapter_id and c.mark_deleted = 'F'")
    List<Object> findBychapter_id(Integer chapter_id);

    @Query(value = "select new com.penana.backend.Model.chapter_like(c.chapter_id as chapter_id, c.id as id, c.user_id as user_id, c.mark_deleted as mark_deleted) from chapter_like c  where c.user_id = :user_id and c.chapter_id = :chapter_id")
    List<Object> findByuser_idAndChapter_id(Integer user_id, Integer chapter_id);
}
