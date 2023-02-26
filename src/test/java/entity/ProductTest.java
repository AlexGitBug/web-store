package entity;

import entity.enums.Brand;
import entity.enums.Color;
import entity.enums.Model;
import org.junit.jupiter.api.Test;
import util.HibernateUtil;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class ProductTest {

    private static final String URL = "C:/work/photo/";
    @Test
    void checkProductSaveAndGet() {
        try (var sessionFactory = HibernateUtil.buildSessionFactory();
             var session = sessionFactory.openSession()) {
            var product = getProduct();
            session.beginTransaction();

            session.save(product);

            session.getTransaction().commit();
            var actualResult = session.get(Product.class, product.getId());
            assertThat(actualResult).isEqualTo(product);
        }

    }

    private Product getProduct() {
        return Product.builder()
                .catalogId(1)
                .brand(Brand.SAMSUNG)
                .model(Model.A52)
                .dateOfRelease(LocalDate.of(2020, 1, 10))
                .price(200)
                .color(Color.WHITE)
                .image(URL+"123.jpg")
                .build();

    }
}
