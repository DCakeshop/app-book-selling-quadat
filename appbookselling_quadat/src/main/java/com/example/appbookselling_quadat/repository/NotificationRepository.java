package com.example.appbookselling_quadat.repository;

import com.example.appbookselling_quadat.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer> {
    Notification findNotificationById(int id);
    Notification findNotificationByMessage(String message);
}
