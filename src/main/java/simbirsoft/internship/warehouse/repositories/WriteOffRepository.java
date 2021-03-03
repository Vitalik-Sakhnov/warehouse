package simbirsoft.internship.warehouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import simbirsoft.internship.warehouse.entities.WriteOff;

public interface WriteOffRepository extends JpaRepository<WriteOff, Long> {
}
