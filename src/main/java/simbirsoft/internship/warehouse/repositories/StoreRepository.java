package simbirsoft.internship.warehouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import simbirsoft.internship.warehouse.entities.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
    Store findByName(String storeName);
}
