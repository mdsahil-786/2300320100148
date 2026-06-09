# Notification System Design

## Stage 1 - API Design

### Notification Object

```json
{
  "id": "uuid",
  "type": "Placement",
  "message": "Amazon Hiring",
  "timestamp": "2026-04-22T17:51:30"
}
```

### APIs


GET  /api/v1/notifications
POST /api/v1/notifications/priority


### Architecture


Client
   ↓
Campus Notification Service
   ↓
External Notification API


The service fetches notifications from the provided API and processes them before returning results.

---

## Stage 2 - Database Design

### Database Choice

MySQL

Reasons:

* Easy integration with Spring Boot
* Reliable relational database
* Supports indexing and efficient querying

### Notifications Table


CREATE TABLE notifications(
    id VARCHAR(255) PRIMARY KEY,
    notification_type VARCHAR(20),
    message TEXT,
    created_at TIMESTAMP
);


### Index


CREATE INDEX idx_type_created
ON notifications(notification_type, created_at);


---

## Stage 3 - Query Optimization

### Original Query


SELECT *
FROM notifications
WHERE notification_type='Placement';


### Optimized Query


SELECT id,
       notification_type,
       message,
       created_at
FROM notifications
WHERE notification_type='Placement';


### Benefits

* Reduced data transfer
* Faster query execution
* Better scalability

---

## Stage 4 - Performance Improvement

### Problem

Repeated API calls increase response time.

### Solution

Store frequently accessed notification data in memory during processing and avoid unnecessary API calls.

Benefits:

* Faster responses
* Reduced network overhead

---

## Stage 5 - Notification Processing

Notifications are processed inside the service layer.

Flow:


Fetch Notifications
        ↓
Calculate Priority Score
        ↓
Sort Notifications
        ↓
Return Top Results


Benefits:

* Simple implementation
* Easy maintenance
* Suitable for current scale

---

## Stage 6 - Priority Inbox

### Priority Weights

| Type      | Weight |
| --------- | ------ |
| Placement | 3      |
| Result    | 2      |
| Event     | 1      |

### Priority Score


(weight × 1000) + timestamp


### Approach

1. Fetch notifications.
2. Assign weight based on type.
3. Calculate score.
4. Sort by score in descending order.
5. Return Top 10 notifications.

### Complexity


O(N log N)


---

## Technologies Used

* Java 17
* Spring Boot
* REST APIs
* MySQL
* Lombok
* Gradle

## Conclusion

The Campus Notification Service retrieves notifications, ranks them using a priority-based scoring system, and returns the most important notifications first. The design is lightweight, easy to maintain, and aligned with the implemented solution.
