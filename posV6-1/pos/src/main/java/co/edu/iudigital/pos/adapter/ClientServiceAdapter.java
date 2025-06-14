package co.edu.iudigital.pos.adapter;

import co.edu.iudigital.pos.adapter.mapper.ClientMapper;
import co.edu.iudigital.pos.domain.model.Client;
import co.edu.iudigital.pos.infrastructure.persistence.JpaClientRepository;
import co.edu.iudigital.pos.port.ClientPort;

import java.util.List;

public class ClientServiceAdapter implements ClientPort {

    private final ClientMapper clientMapper = ClientMapper.INSTANCE;
    private final JpaClientRepository repository;

    public ClientServiceAdapter(JpaClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Client> getAll() {
        return clientMapper.toClients(repository.findAll());
    }

    @Override
    public Client getById(Long id) {
        return clientMapper.toClient(repository.findById(id).orElseThrow());
    }

    @Override
    public Client save(Client client) {
        return clientMapper.toClient(repository.save(clientMapper.toClientEntity(client)));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
