package simbirsoft.internship.warehouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import simbirsoft.internship.warehouse.entities.Warehouse;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
}
