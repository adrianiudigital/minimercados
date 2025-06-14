package co.edu.iudigital.pos.adapter;

import co.edu.iudigital.pos.adapter.mapper.UserMapper;
import co.edu.iudigital.pos.domain.model.User;
import co.edu.iudigital.pos.infrastructure.persistence.JpaUserRepository;
import co.edu.iudigital.pos.infrastructure.persistence.JpaRoleRepository;
import co.edu.iudigital.pos.infrastructure.persistence.entity.RoleEntity;
import co.edu.iudigital.pos.infrastructure.persistence.entity.UserEntity;
import co.edu.iudigital.pos.port.UserPort;

import java.util.List;

public class UserServiceAdapter implements UserPort {

    private final UserMapper userMapper = UserMapper.INSTANCE;
    private final JpaUserRepository userRepository;
    private final JpaRoleRepository roleRepository;

    public UserServiceAdapter(JpaUserRepository userRepository, JpaRoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public List<User> getAll() {
        return userMapper.toUsers(userRepository.findAll());
    }

    @Override
    public User getById(Long id) {
        return userMapper.toUser(userRepository.findById(id).orElseThrow());
    }

    @Override
    public User save(User user) {
        RoleEntity role = roleRepository.findById(user.getRoleId())
                .orElseThrow(() -> new RuntimeException("Role not found"));
        UserEntity entity = userMapper.toUserEntity(user);
        entity.setRole(role);
        return userMapper.toUser(userRepository.save(entity));
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
