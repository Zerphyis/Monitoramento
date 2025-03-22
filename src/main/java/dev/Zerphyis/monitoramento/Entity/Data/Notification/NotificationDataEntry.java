package dev.Zerphyis.monitoramento.Entity.Data.Notification;

import java.time.LocalDateTime;

public record NotificationDataEntry(Long movimentId, String mensage, LocalDateTime dateNotification) {
}
