package dev.Zerphyis.monitoramento.Service;

import dev.Zerphyis.monitoramento.Entity.MovimentStock.MovimentStock;
import dev.Zerphyis.monitoramento.Entity.Notification.Notification;
import dev.Zerphyis.monitoramento.Entity.Product.Product;
import dev.Zerphyis.monitoramento.Repository.MovimentStockRepository;
import dev.Zerphyis.monitoramento.Repository.NotificationRepository;
import dev.Zerphyis.monitoramento.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private MovimentStockRepository movimentStockRepository;

    @Autowired
    private ProductRepository productRepository;

    public Notification saveNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    public List<Notification> listAllNotifications() {
        return notificationRepository.findAll();
    }

    public void deleteNotification(Long id) {
        notificationRepository.deleteById(id);
    }

    public void checkStockAndNotify(Long movimentId) {
        MovimentStock moviment = movimentStockRepository.findById(movimentId)
                .orElseThrow(() -> new RuntimeException("Movimento de estoque não encontrado"));

        Product product = moviment.getProduct();
        Integer updatedQuantity = product.getQuantity() - moviment.getAmounts();

        if (updatedQuantity <= product.getStockAlert()) {
            Notification notification = new Notification();
            notification.setMoviment(moviment);
            notification.setMensage("Atenção: O estoque de " + product.getName() + " atingiu o nível de alerta!");
            notification.setDateNotification(LocalDateTime.now());

            saveNotification(notification);
        }
    }

    public void checkStockReplenishment(Long movimentId) {
        MovimentStock moviment = movimentStockRepository.findById(movimentId)
                .orElseThrow(() -> new RuntimeException("Movimento de estoque não encontrado"));

        Product product = moviment.getProduct();
        Integer updatedQuantity = product.getQuantity() + moviment.getAmounts();

        if (updatedQuantity > product.getStockAlert()) {
            Notification notification = new Notification();
            notification.setMoviment(moviment);
            notification.setMensage("O estoque de " + product.getName() + " foi reabastecido!");
            notification.setDateNotification(LocalDateTime.now());

            saveNotification(notification);
        }
    }
}
