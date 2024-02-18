package com.example.appbookselling_quadat.service.Impl;

import com.example.appbookselling_quadat.beans.response.NotificationResponse;
import com.example.appbookselling_quadat.entity.Notification;
import com.example.appbookselling_quadat.exception.DuplicateException;
import com.example.appbookselling_quadat.exception.NotFoundException;
import com.example.appbookselling_quadat.mapper.NotificationMapper;
import com.example.appbookselling_quadat.repository.NotificationRepository;
import com.example.appbookselling_quadat.service.NotificationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class NotificationServiceImpl implements NotificationService {
    private NotificationRepository notificationRepository;
    @Override
    public List<NotificationResponse> getNotificationList() {
        List<Notification> notifications = notificationRepository.findAll();
        return notifications.stream().map(NotificationMapper::convertToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public NotificationResponse getDetailNotification(int id) throws NotFoundException {
        Notification notification = notificationRepository.findNotificationById(id);
        if (Objects.isNull(notification)){
            throw new NotFoundException("Not Found Objects in Database");
        }
        return NotificationMapper.convertToResponse(notification);
    }

    @Override
    public void createNotification(Notification obj) {
        Notification notification = notificationRepository.findNotificationByMessage(obj.getMessage());
        if (!Objects.isNull(notification)){
            throw new DuplicateException("Message exist in Database");
        }
        else {
            notificationRepository.save(obj);
        }
    }

    @Override
    public void updateNotification(Notification obj) {
        Notification notification = notificationRepository.findNotificationByMessage(obj.getMessage());
        if (!Objects.isNull(notification)){
            throw new DuplicateException("Message exist in Database");
        }
        else {
            notificationRepository.save(obj);
        }
    }

    @Override
    public void delete(int id) {
        Notification notification = notificationRepository.findNotificationById(id);
        if (Objects.isNull(notification)){
            throw new NotFoundException("Not Found Objects in Database");
        }
        else {
            notificationRepository.delete(notification);
        }
    }
}
