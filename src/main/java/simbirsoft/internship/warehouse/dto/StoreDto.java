package simbirsoft.internship.warehouse.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel(value = "model store")
public class StoreDto {
    private Long id;

    @ApiModelProperty(value = "store name", example = "auchan")
    private String name;
}
