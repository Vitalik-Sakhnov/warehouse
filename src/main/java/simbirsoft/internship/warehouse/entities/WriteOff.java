package simbirsoft.internship.warehouse.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "write_off")
public class WriteOff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "reason", nullable = false)
    private String reason;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @PrimaryKeyJoinColumn(name = "product_id")
    private Product product;

    @Column(name = "quantity_of_goods", nullable = false)
    private Long goodsQuantity;

    @Column(name = "approved", nullable = false)
    private boolean isApproved;

    @Column(name = "write_off_date", nullable = false)
    private Date writeOffDate;
}
