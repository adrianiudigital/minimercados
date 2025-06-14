package co.edu.iudigital.pos.adapter.mapper;

import co.edu.iudigital.pos.domain.model.Provider;
import co.edu.iudigital.pos.infrastructure.persistence.entity.ProviderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProviderMapper {

    ProviderMapper INSTANCE = Mappers.getMapper(ProviderMapper.class);

    Provider toProvider(ProviderEntity providerEntity);

    List<Provider> toProviders(List<ProviderEntity> providerEntities);
}
