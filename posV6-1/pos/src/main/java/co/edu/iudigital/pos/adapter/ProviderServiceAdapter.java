package co.edu.iudigital.pos.adapter;

import co.edu.iudigital.pos.adapter.mapper.ProviderMapper;
import co.edu.iudigital.pos.domain.model.Provider;
import co.edu.iudigital.pos.infrastructure.persistence.JpaProviderRepository;
import co.edu.iudigital.pos.port.ProviderPort;

import java.util.List;

public class ProviderServiceAdapter implements ProviderPort {

    private final ProviderMapper providerMapper = ProviderMapper.INSTANCE;

    private final JpaProviderRepository jpaProviderRepository;

    public  ProviderServiceAdapter(
            final JpaProviderRepository jpaProviderRepository
    ){
      this.jpaProviderRepository = jpaProviderRepository;
    }

    @Override
    public List<Provider> getAll() {
        return providerMapper.toProviders(jpaProviderRepository.findAll());
    }

    @Override
    public Provider getById(Long id) {
        return null;
    }

    @Override
    public Provider save(Provider provider) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
