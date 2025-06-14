package co.edu.iudigital.pos.infrastructure.persistence;

import co.edu.iudigital.pos.infrastructure.persistence.entity.ProviderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaProviderRepository extends JpaRepository<ProviderEntity, Long> {
}
