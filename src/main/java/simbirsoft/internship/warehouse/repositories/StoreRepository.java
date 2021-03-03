package simbirsoft.internship.warehouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import simbirsoft.internship.warehouse.entities.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
