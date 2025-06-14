package co.edu.iudigital.pos.service;

import co.edu.iudigital.pos.domain.model.Provider;

import java.util.List;

public interface ProviderService {

    List<Provider> getAllProviders();

    Provider getProviderById(Long id);

    Provider saveProvider(Provider provider);

    void deleteProviderById(Long id);
}
