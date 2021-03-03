package simbirsoft.internship.warehouse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import simbirsoft.internship.warehouse.entities.Product;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WriteOffDto {
    private Long id;
    private String reason;
    private Product product;
    private Long goodsQuantity;
    private boolean isApproved;
    private Date writeOffDate;
}
