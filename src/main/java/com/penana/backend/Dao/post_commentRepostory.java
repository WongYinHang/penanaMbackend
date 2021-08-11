package com.penana.backend.Dao;

import com.penana.backend.Model.post_comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface post_commentRepostory extends JpaRepository<post_comment, Integer> {

}
