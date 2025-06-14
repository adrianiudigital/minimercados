package co.edu.iudigital.pos.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "clientes")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false, unique = true)
    String document;

    @Column(nullable = false)
    String name;

    String phone;

    @Column(unique = true)
    String email;
}
