package co.edu.iudigital.pos.adapter.mapper;

import co.edu.iudigital.pos.domain.model.Sale;
import co.edu.iudigital.pos.infrastructure.persistence.entity.SaleEntity;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface SaleMapper {

    SaleMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(SaleMapper.class);

    @Mapping(source = "client.id", target = "clientId")
    @Mapping(source = "user.id", target = "userId")
    Sale toSale(SaleEntity entity);
}
