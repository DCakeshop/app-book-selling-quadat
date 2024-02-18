package com.example.appbookselling_quadat.controller;

import com.example.appbookselling_quadat.beans.response.NotificationResponse;
import com.example.appbookselling_quadat.entity.Notification;
import com.example.appbookselling_quadat.service.NotificationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notification")
@AllArgsConstructor
public class NotificationController {
    private NotificationService notificationService;

    @GetMapping("/all")
    public List<NotificationResponse> getAllNotification(){
        return notificationService.getNotificationList();
    }

    @GetMapping("/{id}")
    public NotificationResponse getDetailNotification(@PathVariable int id){
        return notificationService.getDetailNotification(id);
    }

    @PostMapping("/create")
    public void create(@RequestBody Notification notification){
        notificationService.createNotification(notification);
    }

    @PutMapping("/edit")
    public void update(@RequestBody Notification notification){
        notificationService.updateNotification(notification);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        notificationService.delete(id);
    }
}
