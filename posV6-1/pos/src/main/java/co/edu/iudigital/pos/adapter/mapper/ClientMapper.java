package co.edu.iudigital.pos.adapter.mapper;

import co.edu.iudigital.pos.domain.model.Client;
import co.edu.iudigital.pos.infrastructure.persistence.entity.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    Client toClient(ClientEntity entity);

    ClientEntity toClientEntity(Client client);

    List<Client> toClients(List<ClientEntity> entities);
}
