package co.edu.iudigital.pos.infrastructure.persistence;

import co.edu.iudigital.pos.infrastructure.persistence.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaClientRepository extends JpaRepository<ClientEntity, Long> {
}
