public class UserService {

    private static final UserDAO _userDao = new UserDAO();

    public static void add(User user) {
        _userDao.add(user);
        System.out.println("Added new user: " + user.getUsername() + " to database HibernateHomeWork");
    }

}
