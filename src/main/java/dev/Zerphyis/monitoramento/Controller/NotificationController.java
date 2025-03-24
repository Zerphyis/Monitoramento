package dev.Zerphyis.monitoramento.Controller;

import dev.Zerphyis.monitoramento.Entity.Data.Notification.NotificationDataEntry;
import dev.Zerphyis.monitoramento.Entity.Data.Notification.NotificationDataExit;
import dev.Zerphyis.monitoramento.Entity.Notification.Notification;
import dev.Zerphyis.monitoramento.Service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/notificacoes")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @GetMapping("/listar")
    public String getNotifications(Model model) {
        List<Notification> notifications = notificationService.listAllNotifications();

        List<NotificationDataEntry> entryData = notifications.stream()
                .filter(notification -> notification.getMoviment() != null)
                .map(notification -> new NotificationDataEntry(
                        notification.getMoviment().getId(),
                        notification.getMensage(),
                        notification.getDateNotification()
                ))
                .collect(Collectors.toList());

        List<NotificationDataExit> exitData = notifications.stream()
                .filter(notification -> notification.getMoviment() != null
                        && notification.getMoviment().getProduct() != null)
                .map(notification -> new NotificationDataExit(
                        notification.getMoviment().getId(),
                        notification.getMoviment().getProduct().getName(),
                        notification.getMensage(),
                        notification.getDateNotification()
                ))
                .collect(Collectors.toList());

        model.addAttribute("entryData", entryData);
        model.addAttribute("exitData", exitData);

        return "notificacoes/listar";
    }

    @GetMapping("/estoque-alerta")
    public String notifyStockAlert(@RequestParam("movimentId") Long movimentId) {
        notificationService.checkStockAndNotify(movimentId);
        return "redirect:/notificacoes/listar";
    }

    @GetMapping("/abastecimento-alerta")
    public String notifyStockReplenishment(@RequestParam("movimentId") Long movimentId) {
        notificationService.checkStockReplenishment(movimentId);
        return "redirect:/notificacoes/listar";
    }

    @PostMapping("/deletar/{id}")
    public String deleteNotification(@PathVariable("id") Long id) {
        notificationService.deleteNotification(id);
        return "redirect:/notificacoes/listar";
    }
}

