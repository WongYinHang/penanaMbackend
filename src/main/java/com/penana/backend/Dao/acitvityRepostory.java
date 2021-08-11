package com.penana.backend.Dao;

import com.penana.backend.Model.acitvity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface acitvityRepostory extends JpaRepository<acitvity, Integer> {

}
