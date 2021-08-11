package com.penana.backend.Dao;

import java.util.List;

import com.penana.backend.Model.comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface commentRepostory extends JpaRepository<comment, Integer> {
    @Query(value = "select new com.penana.backend.Model.comment(c.id as id, c.parent_id as parent_id, c.story_id as story_id, c.chapter as chapter, c.chapter_id as chapter_id, c.user_id as user_id, c.comment as comment, c.post_time as post_time) from comment c  where c.chapter_id = :chapter_id")
    List<Object> findBychapter_id(Integer chapter_id);

    @Query(value = "select new com.penana.backend.Model.comment(c.id as id, c.parent_id as parent_id, c.story_id as story_id, c.chapter as chapter, c.chapter_id as chapter_id, c.user_id as user_id, c.comment as comment, c.post_time as post_time) from comment c  where c.parent_id = :parent_id")
    List<Object> findByparent_id(Integer parent_id);

    @Query(value = "select new com.penana.backend.Model.comment(c.id as id, c.parent_id as parent_id, c.story_id as story_id, c.chapter as chapter, c.chapter_id as chapter_id, c.user_id as user_id, c.comment as comment, c.post_time as post_time) from comment c  where c.user_id = :user_id")
    List<Object> findByuser_id(Integer user_id);
}
