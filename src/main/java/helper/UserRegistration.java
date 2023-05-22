package helper;
public class UserRegistration extends User {
    private String name;

    public UserRegistration(String email, String password, String name) {
        super(email, password);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}