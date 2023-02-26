package entity;

import entity.embedded.DeliveryAdress;
import entity.enums.PaymentCondition;
import org.junit.jupiter.api.Test;
import util.HibernateUtil;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class OrderTest {

    @Test
    void checkOrderSaveAndGet() {
        try (var sessionFactory = HibernateUtil.buildSessionFactory();
             var session = sessionFactory.openSession()) {
            var order = getOrder();
            session.beginTransaction();
            session.save(order);

            session.getTransaction().commit();

            var actualResult = session.get(Order.class, order.getId());
            assertThat(actualResult).isEqualTo(order);

        }

    }

    private Order getOrder() {
        return Order.builder()
                .userId(1)
                .productId(1)
                .deliveryAdress(DeliveryAdress.builder()
                        .city("Minsk")
                        .street("Masherova")
                        .building(1)
                        .build())
                .deliveryDate(LocalDate.of(2022, 2, 25))
                .paymentCondition(PaymentCondition.CARD)
                .build();
    }
}