package simbirsoft.internship.warehouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import simbirsoft.internship.warehouse.entities.WriteOff;

@Repository
public interface WriteOffRepository extends JpaRepository<WriteOff, Long> {
}
