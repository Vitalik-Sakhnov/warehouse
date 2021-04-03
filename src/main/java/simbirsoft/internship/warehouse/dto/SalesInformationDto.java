package simbirsoft.internship.warehouse.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel(value = "model store sum")
public class SalesInformationDto {
    @ApiModelProperty(value = "store name", example = "auchan")
    private String storeName;

    @ApiModelProperty(value = "sales sum", example = "175842")
    private Double salesSum;
}
