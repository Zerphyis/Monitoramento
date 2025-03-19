package dev.Zerphyis.monitoramento.Entity.Product;

import dev.Zerphyis.monitoramento.Entity.Provider.Provider;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "produtos")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotNull
    private Double price;

    @NotNull
    private Integer quantity;

    @NotNull
    @Enumerated(EnumType.STRING)
    private CategoryProduct categoryProduct;

    @ManyToOne
    @JoinColumn(name = "fornecedor_id", nullable = false)
    private Provider provider;

    @NotNull
    private Integer stockAlert;
    public Product(){

    }
    public Product(String name, Double price, Integer quantity, CategoryProduct categoryProduct, Provider provider, Integer stockAlert) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.categoryProduct = categoryProduct;
        this.provider = provider;
        this.stockAlert = stockAlert;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public CategoryProduct getCategoryProduct() {
        return categoryProduct;
    }

    public void setCategoryProduct(CategoryProduct categoryProduct) {
        this.categoryProduct = categoryProduct;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Integer getStockAlert() {
        return stockAlert;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStockAlert(Integer stockAlert) {
        this.stockAlert = stockAlert;
    }
}
