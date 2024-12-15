public class User extends Person {
    public static Object UserType;

    public User(String firstName, String lastName, String username, String password, UserType userType) {
        super(firstName, lastName, username, password, userType);
    }
}
