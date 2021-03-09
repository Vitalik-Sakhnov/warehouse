package simbirsoft.internship.warehouse.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import simbirsoft.internship.warehouse.entities.Product;
import simbirsoft.internship.warehouse.entities.Store;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel(value = "model warehouse")
public class WarehouseDto {
    private Long id;

    @ApiModelProperty(value = "product")
    private Product product;

    @ApiModelProperty(value = "store")
    private Store store;

    @ApiModelProperty(value = "quantity of goods", example = "542")
    private Long goodsQuantity;
}
