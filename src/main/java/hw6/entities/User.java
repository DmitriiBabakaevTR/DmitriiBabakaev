package hw6.entities;

public class User {

    public static final User ROMAN =
            new User("Roman", "Jdi1234", "ROMAN IOVLEV");

    private final String name;
    private final String password;
    private final String fullName;

    public User(String name, String password, String fullName) {
        this.name = name;
        this.password = password;
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }
}
