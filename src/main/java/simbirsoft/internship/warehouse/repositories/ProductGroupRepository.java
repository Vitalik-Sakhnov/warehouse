package simbirsoft.internship.warehouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import simbirsoft.internship.warehouse.entities.ProductGroup;

public interface ProductGroupRepository extends JpaRepository<ProductGroup, Long> {
}
