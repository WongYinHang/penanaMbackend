package com.penana.backend.Dao;

import com.penana.backend.Model.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface postRepostory extends JpaRepository<post, Integer> {

}
