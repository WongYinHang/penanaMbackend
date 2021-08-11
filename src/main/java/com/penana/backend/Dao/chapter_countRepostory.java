package com.penana.backend.Dao;

import com.penana.backend.Model.chapter_count;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface chapter_countRepostory extends JpaRepository<chapter_count, Integer> {

}
