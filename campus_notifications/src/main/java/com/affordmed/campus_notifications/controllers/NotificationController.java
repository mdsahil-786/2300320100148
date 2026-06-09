package com.affordmed.campus_notifications.controllers;

import com.affordmed.campus_notifications.models.Notification;
import com.affordmed.campus_notifications.services.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping("/priority")
    public List<Notification> getPriorityNotifications(
            @RequestBody List<Notification> notifications
    ) {

        return notificationService
                .getTopNotifications(
                        notifications,
                        10
                );
    }
}