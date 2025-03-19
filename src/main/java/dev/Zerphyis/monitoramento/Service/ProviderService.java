package dev.Zerphyis.monitoramento.Service;

import dev.Zerphyis.monitoramento.Entity.Data.DataProvider;
import dev.Zerphyis.monitoramento.Entity.Provider.Provider;
import dev.Zerphyis.monitoramento.Repository.ProviderRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProviderService {
    @Autowired
    ProviderRepository repository;

    public Provider createProvider(DataProvider dataProvider) {
        Provider provider = new Provider(dataProvider);
        return repository.save(provider);
    }

    public List<Provider> getAllProviders() {
        return repository.findAll();
    }

    public Optional<Provider> getProviderById(Long id) {
        return repository.findById(id);
    }

    public Provider updateProvider(Long id, DataProvider dataProvider) {
        return repository.findById(id).map(provider -> {
            provider.setName(dataProvider.name());
            provider.setPhone(dataProvider.phone());
            provider.setEmail(dataProvider.email());
            return repository.save(provider);
        }).orElseThrow(() -> new EntityNotFoundException("Provider not found"));
    }

    public void deleteProvider(Long id) {
        repository.deleteById(id);
    }
}
