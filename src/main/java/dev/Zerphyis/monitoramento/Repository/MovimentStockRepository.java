package dev.Zerphyis.monitoramento.Repository;

import dev.Zerphyis.monitoramento.Entity.MovimentStock.MovimentStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimentStockRepository extends JpaRepository<MovimentStock,Long> {
}
