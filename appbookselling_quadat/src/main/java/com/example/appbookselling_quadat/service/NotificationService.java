package com.example.appbookselling_quadat.service;

import com.example.appbookselling_quadat.beans.response.NotificationResponse;
import com.example.appbookselling_quadat.entity.Notification;
import com.example.appbookselling_quadat.exception.NotFoundException;

import java.util.List;

public interface NotificationService {
    List<NotificationResponse> getNotificationList();
    NotificationResponse getDetailNotification(int id) throws NotFoundException;
    void createNotification(Notification obj);
    void updateNotification(Notification obj);
    void delete(int id);
}
