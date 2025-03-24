package dev.Zerphyis.monitoramento.Entity.MovimentStock;

import dev.Zerphyis.monitoramento.Entity.Product.Product;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "movimentacoes")
public class MovimentStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
    @Enumerated(EnumType.STRING)
    private TypeMoviment typeMoviment;
    @NotNull
    private Integer amounts;
    @NotNull
    private LocalDate date;
    @NotNull
    private LocalTime time;

    public MovimentStock() {

    }

    public MovimentStock(Product product, TypeMoviment typeMoviment, Integer amounts, LocalDate date, LocalTime time) {
        this.product = product;
        this.typeMoviment = typeMoviment;
        this.amounts = amounts;
        this.date = date;
        this.time = time;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public TypeMoviment getTypeMoviment() {
        return typeMoviment;
    }

    public void setTypeMoviment(TypeMoviment typeMoviment) {
        this.typeMoviment = typeMoviment;
    }

    public Integer getAmounts() {
        return amounts;
    }

    public void setAmounts(Integer amounts) {
        this.amounts = amounts;
    }

    public LocalDate getDate() {
        return date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
