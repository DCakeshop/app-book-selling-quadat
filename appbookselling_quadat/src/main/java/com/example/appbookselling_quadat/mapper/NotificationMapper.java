package com.example.appbookselling_quadat.mapper;

import com.example.appbookselling_quadat.beans.response.NotificationResponse;
import com.example.appbookselling_quadat.entity.Notification;

public class NotificationMapper {
    public static NotificationResponse convertToResponse(Notification notification){
        NotificationResponse notificationResponse = new NotificationResponse();
        notificationResponse.setCustomerId(notification.getCustomerId());
        notificationResponse.setMessage(notification.getMessage());
        notificationResponse.setRead(notification.isRead());
        return notificationResponse;
    }
}
