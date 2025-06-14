package co.edu.iudigital.pos.service;

import co.edu.iudigital.pos.domain.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User getById(Long id);
    User save(User user);
    void delete(Long id);
}
