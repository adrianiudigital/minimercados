package co.edu.iudigital.pos.adapter;

import co.edu.iudigital.pos.adapter.mapper.RoleMapper;
import co.edu.iudigital.pos.domain.model.Role;
import co.edu.iudigital.pos.infrastructure.persistence.JpaRoleRepository;
import co.edu.iudigital.pos.port.RolePort;

import java.util.List;

public class RoleServiceAdapter implements RolePort {

    private final RoleMapper roleMapper = RoleMapper.INSTANCE;
    private final JpaRoleRepository jpaRoleRepository;

    public RoleServiceAdapter(JpaRoleRepository jpaRoleRepository) {
        this.jpaRoleRepository = jpaRoleRepository;
    }

    @Override
    public List<Role> getAll() {
        return roleMapper.toRoles(jpaRoleRepository.findAll());
    }

    @Override
    public Role getById(Long id) {
        return roleMapper.toRole(jpaRoleRepository.findById(id).orElseThrow());
    }

    @Override
    public Role save(Role role) {
        return roleMapper.toRole(jpaRoleRepository.save(roleMapper.toRoleEntity(role)));
    }

    @Override
    public void delete(Long id) {
        jpaRoleRepository.deleteById(id);
    }
}
