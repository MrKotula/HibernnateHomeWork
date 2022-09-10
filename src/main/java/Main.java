public class Main {

    public static void main(String[] args){

        UserService.add(new User("Karen", 37));
        UserService.add(new User("Bill", 25));
        UserService.add(new User("Mark", 44));

        User editUser = new User("Rocksana", 48);
        UserService.edit(2, editUser);

        UserService.findName("Mark");

        UserService.getUsers(2, 55);

        UserService.removeUser("Mark");

    }
}
