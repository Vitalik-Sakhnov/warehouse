package simbirsoft.internship.warehouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import simbirsoft.internship.warehouse.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
