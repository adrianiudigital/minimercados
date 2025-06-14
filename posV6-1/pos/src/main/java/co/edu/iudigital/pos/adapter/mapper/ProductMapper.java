package co.edu.iudigital.pos.adapter.mapper;

import co.edu.iudigital.pos.domain.model.Product;
import co.edu.iudigital.pos.infrastructure.persistence.entity.ProductEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(ProductMapper.class);

    @Mapping(source = "category.id", target = "categoryId")
    @Mapping(source = "provider.id", target = "providerId")
    Product toProduct(ProductEntity entity);

    @InheritInverseConfiguration
    @Mapping(target = "category", ignore = true)
    @Mapping(target = "provider", ignore = true)
    ProductEntity toProductEntity(Product product);

    List<Product> toProducts(List<ProductEntity> entities);
}
