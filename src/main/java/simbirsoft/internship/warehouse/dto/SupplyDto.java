package simbirsoft.internship.warehouse.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import simbirsoft.internship.warehouse.entities.Product;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel(value = "model supply")
public class SupplyDto {
    private Long id;

    @ApiModelProperty(value = "product")
    private Product product;

    @ApiModelProperty(value = "quantity of goods", example = "1254")
    private Long goodsQuantity;

    @ApiModelProperty(value = "approved", example = "true")
    private boolean isApproved;

    @ApiModelProperty(value = "supply date", example = "2021.03.21")
    private Date supplyDate;
}
