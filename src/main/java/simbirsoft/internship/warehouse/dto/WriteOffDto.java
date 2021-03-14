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
@ApiModel(value = "model write-off")
public class WriteOffDto {
    private Long id;

    @ApiModelProperty(value = "write-off reason", example = "expired")
    private String reason;

    @ApiModelProperty(value = "product")
    private Product product;

    @ApiModelProperty(value = "quantity of goods", example = "123")
    private Long goodsQuantity;

    @ApiModelProperty(value = "approved", example = "false")
    private boolean isApproved;

    @ApiModelProperty(value = "write off date", example = "2021.04.12")
    private Date writeOffDate;
}
