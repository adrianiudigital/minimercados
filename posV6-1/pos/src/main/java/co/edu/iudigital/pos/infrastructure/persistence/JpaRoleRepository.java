package co.edu.iudigital.pos.infrastructure.persistence;

import co.edu.iudigital.pos.infrastructure.persistence.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaRoleRepository extends JpaRepository<RoleEntity, Long> {
}
