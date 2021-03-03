package simbirsoft.internship.warehouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import simbirsoft.internship.warehouse.entities.Consumption;

public interface ConsumptionRepository extends JpaRepository<Consumption, Long> {
}
