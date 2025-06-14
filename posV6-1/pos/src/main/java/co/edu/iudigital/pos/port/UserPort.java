package co.edu.iudigital.pos.port;

import co.edu.iudigital.pos.domain.model.User;

import java.util.List;

public interface UserPort {

    List<User> getAll();

    User getById(Long id);

    User save(User user);

    void delete(Long id);
}
