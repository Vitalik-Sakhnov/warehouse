package simbirsoft.internship.warehouse.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "consumption")
@ApiModel(value = "model consumption")
public class Consumption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @PrimaryKeyJoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @PrimaryKeyJoinColumn(name = "order_id")
    private Order order;

    @Column(name = "quantity_of_goods", nullable = false)
    @ApiModelProperty(value = "quantity of goods", example = "123")
    private Long goodsQuantity;
}
