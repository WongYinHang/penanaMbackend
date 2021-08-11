package com.penana.backend.Dao;

import java.util.List;

import com.penana.backend.Model.chapter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface chapterRepostory extends JpaRepository<chapter, Integer> {
    @Query(value = "select new com.penana.backend.Model.chapter(c.id as id, c.story_id as story_id, c.chapter as chapter, c.name as name, c.chapter_pic as chapter_pic) from chapter c  where c.story_id = :story_id")
    List<Object> findBystory_id(Integer story_id);
}
