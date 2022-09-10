public class UserService {

    private static final UserDAO _userDao = new UserDAO();

    public static void add(User user) {
        _userDao.add(user);
    }

    public static void edit(int id, User user) {
        _userDao.edit(id, user);
    }

    public static void findName(String name) {
        _userDao.findName(name);
    }

    public static void getUsers(int age1, int age2) {
        _userDao.getUsers(age1, age2);
    }

    public static void removeUser(String name) {
        _userDao.removeUser(name);
    }
}
