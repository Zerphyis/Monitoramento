package dev.Zerphyis.monitoramento.Entity.Data.Notification;

import java.time.LocalDateTime;

public record NotificationDataExit(String productName, String mensage, LocalDateTime dateNotification) {
}
