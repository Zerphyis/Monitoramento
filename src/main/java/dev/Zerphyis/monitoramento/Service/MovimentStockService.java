package dev.Zerphyis.monitoramento.Service;

import dev.Zerphyis.monitoramento.Entity.MovimentStock.MovimentStock;
import dev.Zerphyis.monitoramento.Entity.MovimentStock.TypeMoviment;
import dev.Zerphyis.monitoramento.Entity.Product.Product;
import dev.Zerphyis.monitoramento.Repository.MovimentStockRepository;
import dev.Zerphyis.monitoramento.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class MovimentStockService {
    @Autowired
    private MovimentStockRepository movimentRepository;
    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public void registerMoviment(Long productId, TypeMoviment typeMoviment, Integer amounts) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        if (typeMoviment == TypeMoviment.ENTRADA) {
            product.setQuantity(product.getQuantity() + amounts);
        } else if (typeMoviment == TypeMoviment.SAIDA) {
            if (product.getQuantity() < amounts) {
                throw new RuntimeException("Quantidade insuficiente em estoque");
            }
            product.setQuantity(product.getQuantity() - amounts);
        }

        MovimentStock movimentStock = new MovimentStock(product, typeMoviment, amounts, LocalDate.now(), LocalTime.now());
        movimentRepository.save(movimentStock);
        productRepository.save(product);
    }

    public List<MovimentStock> getAllMoviments() {
        return movimentRepository.findAll();
    }

    public MovimentStock getMovimentById(Long id) {
        return movimentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movimentação não encontrada"));
    }

    @Transactional
    public void updateMoviment(Long id, TypeMoviment typeMoviment, Integer amounts) {
        MovimentStock movimentStock = movimentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movimentação não encontrada"));

        movimentStock.setTypeMoviment(typeMoviment);
        movimentStock.setAmounts(amounts);
        movimentRepository.save(movimentStock);
    }

    @Transactional
    public void deleteMoviment(Long id) {
        MovimentStock movimentStock = movimentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movimentação não encontrada"));
        movimentRepository.delete(movimentStock);
    }
}
