package dev.Zerphyis.monitoramento.Entity.Data;

import dev.Zerphyis.monitoramento.Entity.Product.CategoryProduct;

public record DataProductExit(
        Long id,
        String name, Double price , Integer quantity,
        CategoryProduct categoryProduct,String providerName,
        Integer stockAlert) {
}
