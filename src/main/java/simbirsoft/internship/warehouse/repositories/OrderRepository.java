package simbirsoft.internship.warehouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import simbirsoft.internship.warehouse.dto.SalesInformationDto;
import simbirsoft.internship.warehouse.entities.Order;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("SELECT s.name as storeName, sum(o.orderPrice) as salesSum " +
            "FROM Store s, Product p, Consumption c, Order o, Warehouse w " +
            "WHERE o.id=c.order.id and c.product.id=p.id and p.id=w.product.id and w.store.id=s.id")
    List<SalesInformationDto> salesSum();
}
