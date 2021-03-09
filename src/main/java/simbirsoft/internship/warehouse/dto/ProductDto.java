package simbirsoft.internship.warehouse.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import simbirsoft.internship.warehouse.entities.ProductGroup;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel(value = "model product")
public class ProductDto {
    private Long id;

    @ApiModelProperty(value = "product name", example = "oranges")
    private String name;

    @ApiModelProperty(value = "product group")
    private ProductGroup productGroup;

    @ApiModelProperty(value = "product price", example = "2021.15")
    private Double price;
}
