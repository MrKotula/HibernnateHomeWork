import javax.persistence.*;
import javax.transaction.Transactional;

@Transactional
public class UserDAO {

    private static final EntityManagerFactory MANAGER_FACTORY = Persistence.createEntityManagerFactory("hibernatehomework");

    @PersistenceContext
    public static void add(User user){
        EntityManager entityManager = MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(user);
        entityTransaction.commit();
    }

}
