package co.edu.iudigital.pos.service.impl;

import co.edu.iudigital.pos.domain.model.Provider;
import co.edu.iudigital.pos.port.ProviderPort;
import co.edu.iudigital.pos.service.ProviderService;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class ProviderServiceImpl implements ProviderService {

    private final ProviderPort providerPort;

    public ProviderServiceImpl(
            final ProviderPort providerPort
    ) {
        this.providerPort = providerPort;
    }

    @Override
    public List<Provider> getAllProviders() {
        //
        log.debug("dubugging getAllProviders");
        return providerPort.getAll();
    }

    @Override
    public Provider getProviderById(final Long id) {
        //
        return providerPort.getById(id);
    }

    @Override
    public Provider saveProvider(final Provider provider) {
        return providerPort.save(provider);
    }

    @Override
    public void deleteProviderById(final Long id) {
        providerPort.delete(id);
    }
}
