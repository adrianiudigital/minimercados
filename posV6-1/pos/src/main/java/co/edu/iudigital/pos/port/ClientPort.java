package co.edu.iudigital.pos.port;

import co.edu.iudigital.pos.domain.model.Client;

import java.util.List;

public interface ClientPort {

    List<Client> getAll();

    Client getById(Long id);

    Client save(Client client);

    void delete(Long id);
}
