package simbirsoft.internship.warehouse.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashMap;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel(value = "model purchase")
public class PurchaseDto {
    private Long purchaseId;

    private Long consumptionId;

    @ApiModelProperty(value = "purchase map, key - product id, value - product quantity", example = "1, 1254")
    private HashMap<Long, Long> products;

    @ApiModelProperty(value = "purchase date", example = "2021.12.20")
    private Date orderDate;
}
