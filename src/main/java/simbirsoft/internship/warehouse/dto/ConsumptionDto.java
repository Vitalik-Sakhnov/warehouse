package simbirsoft.internship.warehouse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import simbirsoft.internship.warehouse.entities.Order;
import simbirsoft.internship.warehouse.entities.Product;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ConsumptionDto {
    private Long id;
    private Product product;
    private Order order;
    private Long goodsQuantity;
}
