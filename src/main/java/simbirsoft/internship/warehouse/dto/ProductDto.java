package simbirsoft.internship.warehouse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import simbirsoft.internship.warehouse.entities.ProductGroup;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDto {
    private Long id;
    private String name;
    private ProductGroup productGroup;
    private Double price;
}
