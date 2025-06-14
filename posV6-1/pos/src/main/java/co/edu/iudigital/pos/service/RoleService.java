package co.edu.iudigital.pos.service;

import co.edu.iudigital.pos.domain.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAll();
    Role getById(Long id);
    Role save(Role role);
    void delete(Long id);
}
