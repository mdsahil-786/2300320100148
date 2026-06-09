package com.affordmed.campus_notifications.utils;

import com.affordmed.campus_notifications.models.Notification;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

public class NotificationPriorityUtil {

    public static List<Notification> getTopNotifications(
            List<Notification> notifications,
            int limit
    ) {

        notifications.sort(
                Comparator.comparingDouble(
                        NotificationPriorityUtil::calculateScore
                ).reversed()
        );

        return notifications
                .stream()
                .limit(limit)
                .toList();
    }

    private static double calculateScore(
            Notification notification
    ) {

        int weight = switch (
                notification.getType()
                ) {
            case "Placement" -> 3;
            case "Result" -> 2;
            case "Event" -> 1;
            default -> 0;
        };

        LocalDateTime time =
                LocalDateTime.parse(
                        notification.getTimestamp()
                );

        long epoch =
                time.atZone(
                        java.time.ZoneId.systemDefault()
                ).toEpochSecond();

        return weight * 1000000L + epoch;
    }
}