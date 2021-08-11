package com.penana.backend.Dao;

import java.util.Optional;

import com.penana.backend.Model.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepostory extends JpaRepository<user, Integer> {
    user findByusername(String username);

    user findByemail(Object getemail);

    @Query(value = "SELECT new com.penana.backend.Model.user(u.id as id, u.username as username, u.display_name as display_name, u.email as email, u.profile_picture as profile_picture ) from user u  where u.email = :email")
    Optional<Object> findByEmail(@Param("email") String email);

}
