package com.affordmed.campus_notifications.services;

import com.affordmed.campus_notifications.models.Notification;
import com.affordmed.campus_notifications.utils.NotificationPriorityUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    public List<Notification> getTopNotifications(
            List<Notification> notifications,
            int topN
    ) {
        return NotificationPriorityUtil
                .getTopNotifications(notifications, topN);
    }
}