package com.affordmed.campus_notifications.models;

import lombok.Data;

@Data
public class Notification {

    private String id;

    private String type;

    private String message;

    private String timestamp;
}