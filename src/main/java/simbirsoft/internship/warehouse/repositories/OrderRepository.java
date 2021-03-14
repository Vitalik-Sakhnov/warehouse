package simbirsoft.internship.warehouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import simbirsoft.internship.warehouse.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
