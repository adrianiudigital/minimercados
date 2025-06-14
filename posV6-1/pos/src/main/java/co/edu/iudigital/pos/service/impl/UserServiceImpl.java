package co.edu.iudigital.pos.service.impl;

import co.edu.iudigital.pos.domain.model.User;
import co.edu.iudigital.pos.port.UserPort;
import co.edu.iudigital.pos.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserPort userPort;

    public UserServiceImpl(UserPort userPort) {
        this.userPort = userPort;
    }

    @Override
    public List<User> getAll() {
        return userPort.getAll();
    }

    @Override
    public User getById(Long id) {
        return userPort.getById(id);
    }

    @Override
    public User save(User user) {
        return userPort.save(user);
    }

    @Override
    public void delete(Long id) {
        userPort.delete(id);
    }
}
