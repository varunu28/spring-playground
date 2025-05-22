import java.time.LocalDate;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HibernateExampleTest {
    private SessionFactory sessionFactory;

    @BeforeEach
    protected void setUp() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure()
            .build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    @AfterEach
    protected void tearDown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

    @Test
    void hql_save_user() {
        User user = new User("Lisa", LocalDate.now());
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            session.persist(user);

            session.getTransaction().commit();
        }
    }

    @Test
    void hql_fetch_users() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            List<User> users = session.createQuery("select u from User u", User.class).list();

            users.forEach(System.out::println);

            session.getTransaction().commit();
        }
    }

    @Test
    @Disabled
    public void hql_fetch_specific_user() {
        var userName = "Alice";
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            List<User> users = session.createQuery("select u from User u where u.name=:username", User.class)
                .setParameter("username", userName)
                .list();

            assertEquals(1, users.size());
            assertEquals(userName, users.getFirst().getName());

            session.getTransaction().commit();
        }
    }
}
