package dev.Zerphyis.monitoramento.Repository;

import dev.Zerphyis.monitoramento.Entity.Product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
