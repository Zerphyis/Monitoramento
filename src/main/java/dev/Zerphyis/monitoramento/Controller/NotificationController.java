package dev.Zerphyis.monitoramento.Controller;

import dev.Zerphyis.monitoramento.Entity.Notification.Notification;
import dev.Zerphyis.monitoramento.Service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/notificacoes")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @GetMapping("/listar")
    public String listarNotificacoes(Model model) {
        List<Notification> notificacoes = notificationService.listAllNotifications();
        model.addAttribute("notificacoes", notificacoes);
        return "notificacoes/listar";
    }

    @GetMapping("/formulario")
    public String exibirFormulario() {
        return "notificacoes/form";
    }

    @GetMapping("/alerta-estoque")
    public String notifyStockAlert(@RequestParam("movimentId") Long movimentId) {
        notificationService.checkStockAndNotify(movimentId);
        return "redirect:/notificacoes/listar";
    }

    @GetMapping("/alerta-abastecimento")
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

