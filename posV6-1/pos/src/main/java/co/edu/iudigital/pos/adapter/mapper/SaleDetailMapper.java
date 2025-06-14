package co.edu.iudigital.pos.adapter.mapper;

import co.edu.iudigital.pos.domain.model.SaleDetail;
import co.edu.iudigital.pos.infrastructure.persistence.entity.SaleDetailEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SaleDetailMapper {

    SaleDetailMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(SaleDetailMapper.class);

    SaleDetail toSaleDetail(SaleDetailEntity entity);
}
