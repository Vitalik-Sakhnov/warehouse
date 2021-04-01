package simbirsoft.internship.warehouse.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel(value = "model sold product")
public class SoldProductDto {
    @ApiModelProperty(value = "store name", example = "Mega")
    private String storeName;

    @ApiModelProperty(value = "product name", example = "Oranges")
    private String productName;

    @ApiModelProperty(value = "sales sum", example = "175842")
    private Double goodsSold;
}
