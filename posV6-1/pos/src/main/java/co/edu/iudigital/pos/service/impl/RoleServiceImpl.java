package co.edu.iudigital.pos.service.impl;

import co.edu.iudigital.pos.domain.model.Role;
import co.edu.iudigital.pos.port.RolePort;
import co.edu.iudigital.pos.service.RoleService;

import java.util.List;

public class RoleServiceImpl implements RoleService {

    private final RolePort rolePort;

    public RoleServiceImpl(RolePort rolePort) {
        this.rolePort = rolePort;
    }

    @Override
    public List<Role> getAll() {
        return rolePort.getAll();
    }

    @Override
    public Role getById(Long id) {
        return rolePort.getById(id);
    }

    @Override
    public Role save(Role role) {
        return rolePort.save(role);
    }

    @Override
    public void delete(Long id) {
        rolePort.delete(id);
    }
}
