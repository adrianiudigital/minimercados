package co.edu.iudigital.pos.adapter.mapper;

import co.edu.iudigital.pos.domain.model.User;
import co.edu.iudigital.pos.infrastructure.persistence.entity.UserEntity;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "role.id", target = "roleId")
    User toUser(UserEntity entity);

    @InheritInverseConfiguration
    @Mapping(target = "role", ignore = true) // se asigna aparte
    UserEntity toUserEntity(User user);

    List<User> toUsers(List<UserEntity> entities);
}
