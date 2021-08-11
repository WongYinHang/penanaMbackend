package com.penana.backend.Dao;

import com.penana.backend.Model.tags;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface tagsRepostory extends JpaRepository<tags, Integer> {

}
