package dev.Zerphyis.monitoramento.Entity.Data;

import dev.Zerphyis.monitoramento.Entity.Product.CategoryProduct;

public record DataProductEntry(
        String name, Double price , Integer quantity,
        CategoryProduct categoryProduct,Long providerId,
        Integer stockAlert) {
}
