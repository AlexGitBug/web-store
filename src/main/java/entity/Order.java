package entity;

import entity.embedded.DeliveryAdress;
import entity.enums.PaymentCondition;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "orders", schema = "public")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "product_id")
    private Integer productId;

    @Embedded
    private DeliveryAdress deliveryAdress;

    @Column(name = "delivery_date")
    private LocalDate deliveryDate;

    @Column(name = "payment_condition")
    @Enumerated(EnumType.STRING)
    private PaymentCondition paymentCondition;
}
