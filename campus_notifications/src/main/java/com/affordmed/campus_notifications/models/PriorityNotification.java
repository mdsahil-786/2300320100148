package com.affordmed.campus_notifications.models;

import com.affordmed.campus_notifications.models.Notification;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PriorityNotification {

    private Notification notification;

    private double score;
}