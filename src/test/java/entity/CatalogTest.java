package entity;

import entity.enums.Category;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import util.SessionUtil;

import static org.assertj.core.api.Assertions.assertThat;

class CatalogTest {

    @Test
    void checkCatalogSaveAndGet() {
        try (Session session = SessionUtil.openTransactionSession()) {
            var catalog = getCatalog();
            session.save(catalog);

            SessionUtil.closeTransactionSession();

            var actualResult = session.get(Catalog.class, catalog.getId());
            assertThat(actualResult).isEqualTo(catalog);
        }

//        try (var sessionFactory = HibernateUtil.buildSessionFactory();
//             var session = sessionFactory.openSession()) {
//            session.beginTransaction();
//            var catalog = getCatalog();
//            session.save(catalog);
//
//            session.getTransaction().commit();
//
//            var actualResult = session.get(Catalog.class, catalog.getId());
//            assertThat(actualResult).isEqualTo(catalog);
//
//        }

    }
    private Catalog getCatalog() {
        return Catalog.builder()
                .category(Category.IPAD)
                .build();
    }
}
