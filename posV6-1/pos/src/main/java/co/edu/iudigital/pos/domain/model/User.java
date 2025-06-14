package co.edu.iudigital.pos.domain.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    Long id;

    String username;

    String email;

    String password;

    Long roleId; // Asociación con Rol
}
