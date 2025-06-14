package co.edu.iudigital.pos.port;

import co.edu.iudigital.pos.domain.model.Provider;

import java.util.List;

public interface ProviderPort {

    List<Provider> getAll();

    Provider getById(Long id);

    Provider save(Provider provider);

    void delete(Long id);
}
