package simbirsoft.internship.warehouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import simbirsoft.internship.warehouse.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
