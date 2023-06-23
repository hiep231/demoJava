package demo_oop_03;

public class AccountModel {
    private String username;
    private String password;

    public AccountModel(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }

    public AccountModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AccountModel{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
