package simbirsoft.internship.warehouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import simbirsoft.internship.warehouse.entities.Supply;

@Repository
public interface SupplyRepository extends JpaRepository<Supply, Long> {
}
