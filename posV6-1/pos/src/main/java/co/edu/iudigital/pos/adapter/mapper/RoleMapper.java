package co.edu.iudigital.pos.adapter.mapper;

import co.edu.iudigital.pos.domain.model.Role;
import co.edu.iudigital.pos.infrastructure.persistence.entity.RoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    Role toRole(RoleEntity entity);

    RoleEntity toRoleEntity(Role role);

    List<Role> toRoles(List<RoleEntity> entities);
}
