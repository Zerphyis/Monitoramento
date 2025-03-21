package dev.Zerphyis.monitoramento.Entity.Data.Moviment;

import dev.Zerphyis.monitoramento.Entity.MovimentStock.TypeMoviment;

import java.time.LocalDate;
import java.time.LocalTime;

public record DataMovimentExit(String Nameproduct,
                               TypeMoviment typeMoviment,
                               Integer amounts,
                               LocalDate date,
                               LocalTime time) {
}
