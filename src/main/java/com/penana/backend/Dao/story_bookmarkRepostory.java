package com.penana.backend.Dao;

import java.util.List;

import com.penana.backend.Model.story_bookmark;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface story_bookmarkRepostory extends JpaRepository<story_bookmark, Integer> {
    @Query(value = "select new com.penana.backend.Model.story_bookmark(s.id as id, s.user_id as user_id, s.story_id as story_id, s.chapter as chapter, s.mark_deleted as mark_deleted) from story_bookmark s where s.user_id = :user_id")
    List<Object> findByuser_id(Integer user_id);

    @Query(value = "select new com.penana.backend.Model.story_bookmark(s.id as id, s.user_id as user_id, s.story_id as story_id, s.chapter as chapter, s.mark_deleted as mark_deleted) from story_bookmark s where s.user_id = :user_id and s.story_id = :story_id")
    List<Object> findByuser_idAndStory_id(Integer user_id, Integer story_id);
}
