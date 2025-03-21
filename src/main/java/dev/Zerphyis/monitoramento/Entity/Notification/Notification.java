package dev.Zerphyis.monitoramento.Entity.Notification;

import dev.Zerphyis.monitoramento.Entity.MovimentStock.MovimentStock;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "notificacoes")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "movimentoEstoque_id", nullable = false)
    private MovimentStock moviment;

    @NotBlank
    private String mensage;

    @NotNull
    private LocalDateTime dateNotification;

    public Notification(MovimentStock moviment, String mensage) {
        this.moviment = moviment;
        this.mensage = mensage;
        this.dateNotification = LocalDateTime.now();
    }

    public Notification() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MovimentStock getMoviment() {
        return moviment;
    }

    public void setMoviment(MovimentStock moviment) {
        this.moviment = moviment;
    }

    public String getMensage() {
        return mensage;
    }

    public void setMensage(String mensage) {
        this.mensage = mensage;
    }

    public LocalDateTime getDateNotification() {
        return dateNotification;
    }

    public void setDateNotification(LocalDateTime dateNotification) {
        this.dateNotification = dateNotification;
    }
}
