package simbirsoft.internship.warehouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import simbirsoft.internship.warehouse.entities.Consumption;

@Repository
public interface ConsumptionRepository extends JpaRepository<Consumption, Long> {
}
