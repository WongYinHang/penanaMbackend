package com.penana.backend.Dao;

import com.penana.backend.Model.user_profile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface user_profileRepostory extends JpaRepository<user_profile, Integer> {

}
