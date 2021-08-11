package com.penana.backend.Dao;

import java.util.List;

import com.penana.backend.Model.story_all;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface story_allRepostory extends JpaRepository<story_all, Integer> {

    @Query(value = "select new com.penana.backend.Model.story_all(s.id as id, s.title as title, s.genre_sid as genre_sid, s.subgenre1 as subgenre1, s.subgenre2 as subgenre2, s.bookmark_count as bookmark_count, s.book_cover as book_cover, s.preview as preview, s.rating as rating, s.popularity as popularity ) from story_all s  where s.genre_sid = :genre_sid")
    List<Object> findBygenre_sid(Integer genre_sid);

    @Query(value = "select new com.penana.backend.Model.story_all(s.id as id, s.title as title, s.genre_sid as genre_sid, s.subgenre1 as subgenre1, s.subgenre2 as subgenre2, s.bookmark_count as bookmark_count, s.book_cover as book_cover, s.preview as preview, s.rating as rating, s.popularity as popularity ) from story_all s where created_by = :created_by")
    List<Object> findBycreated_by(Integer created_by);

    @Query(value = "SELECT new com.penana.backend.Model.story_all(s.id as id, s.title as title, s.genre_sid as genre_sid, s.subgenre1 as subgenre1, s.subgenre2 as subgenre2, s.bookmark_count as bookmark_count, s.book_cover as book_cover, s.preview as preview, s.rating as rating, s.popularity as popularity ) FROM story_all s ORDER BY popularity DESC LIMIT 5")
    List<Object> findBypopularity();

}
