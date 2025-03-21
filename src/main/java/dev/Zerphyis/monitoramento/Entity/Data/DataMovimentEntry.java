package dev.Zerphyis.monitoramento.Entity.Data;

import dev.Zerphyis.monitoramento.Entity.MovimentStock.TypeMoviment;
import dev.Zerphyis.monitoramento.Entity.Product.Product;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

public record DataMovimentEntry( Long Idproduct,
         TypeMoviment typeMoviment,
   Integer amounts,
    LocalDate date,
    LocalTime time) {
}
