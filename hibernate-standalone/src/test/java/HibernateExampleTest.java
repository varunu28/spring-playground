import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HibernateExampleTest {
    private EntityManagerFactory entityManagerFactory;

    @BeforeEach
    protected void setUp() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure()
            .build();
        try {
            entityManagerFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    @AfterEach
    protected void tearDown() {
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }

    @Test
    void hql_save_user() {
        User user = new User(UUID.randomUUID().toString(), LocalDate.now());
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(user);

        entityManager.getTransaction().commit();
    }

    @Test
    void hql_fetch_users() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        List<User> users = entityManager.createQuery("select u from User u", User.class).getResultList();
        users.forEach(System.out::println);

        entityManager.getTransaction().commit();
    }

    @Test
    void hql_fetch_specific_user() {
        var userName = "Alice";
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        List<User> users = entityManager.createQuery("select u from User u where u.name=:username", User.class)
            .setParameter("username", userName)
            .getResultList();

        assertEquals(1, users.size());
        assertEquals(userName, users.getFirst().getName());

        entityManager.getTransaction().commit();
    }

    @Test
    void criteria_api() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> root = cq.from(User.class); // SELECT u FROM User u
        cq.select(root).where(cb.equal(root.get(User_.NAME), "Alice")); // WHERE u.name = :username

        TypedQuery<User> typedQuery = entityManager.createQuery(cq);
        List<User> users = typedQuery.getResultList();
        assertEquals(1, users.size());
        assertEquals("Alice", users.getFirst().getName());

        entityManager.close();
    }
}
