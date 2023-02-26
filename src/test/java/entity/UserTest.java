package entity;

import entity.User;
import entity.enums.Role;
import org.junit.jupiter.api.Test;
import util.HibernateUtil;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    @Test
    void checkUserSaveAndGet() {

        try (var sessionFactory = HibernateUtil.buildSessionFactory();
             var session = sessionFactory.openSession()) {
            var user = getUser();
            session.beginTransaction();
            session.save(user);

            session.getTransaction().commit();

            var actualResult = session.get(User.class, user.getId());
            assertThat(actualResult).isEqualTo(user);
        }
    }

    private User getUser() {
        return User.builder()
                .firstName("Test")
                .lastName("Testov")
                .email("test@mail.ru")
                .password("test")
                .telephone("test")
                .birthDate(LocalDate.of(2020, 2, 2))
                .role(Role.USER)
                .build();
    }
}