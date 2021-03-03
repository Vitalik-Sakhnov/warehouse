package simbirsoft.internship.warehouse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import simbirsoft.internship.warehouse.entities.Product;
import simbirsoft.internship.warehouse.entities.Store;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WarehouseDto {
    private Long id;
    private Product product;
    private Store store;
    private Long goodsQuantity;
}
