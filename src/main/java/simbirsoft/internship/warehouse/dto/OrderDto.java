package simbirsoft.internship.warehouse.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel(value = "model order")
public class OrderDto {
    private Long id;

    @ApiModelProperty(value = "order price", example = "152.32")
    private Double orderPrice;

    @ApiModelProperty(value = "order date", example = "2021.12.20")
    private Date orderDate;
}
