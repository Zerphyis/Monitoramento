package dev.Zerphyis.monitoramento.Service;

import dev.Zerphyis.monitoramento.Entity.Data.Product.DataProductEntry;
import dev.Zerphyis.monitoramento.Entity.Data.Product.DataProductExit;
import dev.Zerphyis.monitoramento.Entity.Product.Product;
import dev.Zerphyis.monitoramento.Entity.Provider.Provider;
import dev.Zerphyis.monitoramento.Repository.ProductRepository;
import dev.Zerphyis.monitoramento.Repository.ProviderRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProviderRepository providerRepository;

    public Product createProduct(DataProductEntry dataProductEntry) {
        Optional<Provider> provider = providerRepository.findById(dataProductEntry.providerId());

        if (provider.isEmpty()) {
            throw new EntityNotFoundException("Provider not found");
        }

        Product product = new Product(
                dataProductEntry.name(),
                dataProductEntry.price(),
                dataProductEntry.quantity(),
                dataProductEntry.categoryProduct(),
                provider.get(),
                dataProductEntry.stockAlert()
        );

        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product updateProduct(Long id, DataProductEntry dataProductEntry) {
        return productRepository.findById(id).map(product -> {
            Optional<Provider> provider = providerRepository.findById(dataProductEntry.providerId());
            if (provider.isEmpty()) {
                throw new EntityNotFoundException("Provider not found");
            }

            product.setName(dataProductEntry.name());
            product.setPrice(dataProductEntry.price());
            product.setQuantity(dataProductEntry.quantity());
            product.setCategoryProduct(dataProductEntry.categoryProduct());
            product.setProvider(provider.get());
            product.setStockAlert(dataProductEntry.stockAlert());

            return productRepository.save(product);
        }).orElseThrow(() -> new EntityNotFoundException("Product not found"));
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public DataProductExit convertToDataProductExit(Product product) {
        return new DataProductExit(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getQuantity(),
                product.getCategoryProduct(),
                product.getProvider().getName(),
                product.getStockAlert()
        );
    }
}
