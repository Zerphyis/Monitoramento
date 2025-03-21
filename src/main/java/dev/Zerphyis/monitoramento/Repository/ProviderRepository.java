package dev.Zerphyis.monitoramento.Repository;

import dev.Zerphyis.monitoramento.Entity.Provider.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends JpaRepository<Provider,Long> {
}
