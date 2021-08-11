package com.penana.backend.Dao;

import com.penana.backend.Model.message;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface messageRepostory extends JpaRepository<message, Integer> {

}
