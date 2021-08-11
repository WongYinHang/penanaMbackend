package com.penana.backend.Dao;

import com.penana.backend.Model.notification;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface notificationRepostory extends JpaRepository<notification, Integer> {

}
