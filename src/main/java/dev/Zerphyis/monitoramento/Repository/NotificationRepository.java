package dev.Zerphyis.monitoramento.Repository;

import dev.Zerphyis.monitoramento.Entity.Notification.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification,Long> {
}
