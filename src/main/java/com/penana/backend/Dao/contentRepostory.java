package com.penana.backend.Dao;

import java.util.List;

import com.penana.backend.Model.content;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface contentRepostory extends JpaRepository<content, Integer> {
    @Query(value = "select new com.penana.backend.Model.content(c.chapter_id as chapter_id, c.content as content) from content c  where c.chapter_id = :chapter_id")
    List<Object> findBychapter_id(Integer chapter_id);
}
