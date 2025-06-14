package co.edu.iudigital.pos.infrastructure.persistence;

import co.edu.iudigital.pos.infrastructure.persistence.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaCategoryRepository extends JpaRepository<CategoryEntity, Long> {
}
