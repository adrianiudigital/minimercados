package co.edu.iudigital.pos.service.impl;

import co.edu.iudigital.pos.domain.model.Client;
import co.edu.iudigital.pos.port.ClientPort;
import co.edu.iudigital.pos.service.ClientService;

import java.util.List;

public class ClientServiceImpl implements ClientService {

    private final ClientPort port;

    public ClientServiceImpl(ClientPort port) {
        this.port = port;
    }

    @Override
    public List<Client> getAll() {
        return port.getAll();
    }

    @Override
    public Client getById(Long id) {
        return port.getById(id);
    }

    @Override
    public Client save(Client client) {
        return port.save(client);
    }

    @Override
    public void delete(Long id) {
        port.delete(id);
    }
}
