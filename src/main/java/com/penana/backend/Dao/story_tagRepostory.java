package com.penana.backend.Dao;

import com.penana.backend.Model.story_tag;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface story_tagRepostory extends JpaRepository<story_tag, Integer> {

}
