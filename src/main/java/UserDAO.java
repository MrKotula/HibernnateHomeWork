import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

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
        System.out.println("Added new user: " + user.getUsername() + " to database HibernateHomeWork");
        entityManager.close();
    }
    @PersistenceContext
    public static void edit(int id, User user){
        EntityManager entityManager = MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        User newUser = entityManager.find(User.class,id);
        newUser.setUsername(user.getUsername());
        newUser.setAge(user.getAge());
        entityTransaction.commit();
        System.out.println("Changes for object with id: " + newUser.getId() + " in database HibernateHomeWork");
        entityManager.close();
    }

    @PersistenceContext
    public static List<User> findName(String name){
        EntityManager entityManager = MANAGER_FACTORY.createEntityManager();
       String query = "SELECT i FROM User i WHERE i.username = :id";
       TypedQuery<User> typedQuery = entityManager.createQuery(query, User.class);
       typedQuery.setParameter("id", name);
       List<User> list = typedQuery.getResultList();
            for(User user : list)
        System.out.println("Username: " + user.getUsername() + ", his(her) age - " + user.getAge());
        entityManager.close();
        return list;
     }

    @PersistenceContext
    public static List<User> getUsers(int age1, int age2){
        EntityManager entityManager = MANAGER_FACTORY.createEntityManager();
        String query = "SELECT i FROM User i WHERE i.age BETWEEN :id1 AND :id2";
        TypedQuery<User> typedQuery = entityManager.createQuery(query, User.class);
        typedQuery.setParameter("id1", age1);
        typedQuery.setParameter("id2", age2);
        List<User> list = typedQuery.getResultList();
            for(User user : list)
        System.out.println("Username: " + user.getUsername() + ", age: " + user.getAge());
        entityManager.close();
        return list;
    }

    @PersistenceContext
    public static User removeUser(String name){
        EntityManager entityManager = MANAGER_FACTORY.createEntityManager();
        String query = "SELECT i FROM User i WHERE i.username = :id1";
        TypedQuery<User> typedQuery = entityManager.createQuery(query, User.class);
        typedQuery.setParameter("id1", name);
        User user = typedQuery.getSingleResult();

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.find(User.class, user.getId());
        entityManager.remove(user);
        entityTransaction.commit();
        entityManager.close();
        System.out.println("Removed user with name " + user.getUsername());
        return user;
    }
}
