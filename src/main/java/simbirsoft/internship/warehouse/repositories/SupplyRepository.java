package simbirsoft.internship.warehouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import simbirsoft.internship.warehouse.entities.Supply;

public interface SupplyRepository extends JpaRepository<Supply, Long> {
}
