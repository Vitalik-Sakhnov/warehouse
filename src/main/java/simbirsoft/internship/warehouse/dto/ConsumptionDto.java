package simbirsoft.internship.warehouse.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import simbirsoft.internship.warehouse.entities.Order;
import simbirsoft.internship.warehouse.entities.Product;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel(value = "model consumption")
public class ConsumptionDto {
    @ApiModelProperty(value = "product")
    private Product product;

    @ApiModelProperty(value = "order")
    private Order order;

    @ApiModelProperty(value = "quantity of goods", example = "123")
    private Long goodsQuantity;
}
