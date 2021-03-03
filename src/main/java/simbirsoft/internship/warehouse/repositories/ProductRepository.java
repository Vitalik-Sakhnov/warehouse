package simbirsoft.internship.warehouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import simbirsoft.internship.warehouse.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
