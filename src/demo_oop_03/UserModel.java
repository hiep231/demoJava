package demo_oop_03;

public class UserModel {
    private String name;
    private AccountModel accountModel;

    public UserModel() {
    }

    public UserModel(String name, AccountModel accountModel) {
        super();
        this.name = name;
        this.accountModel = accountModel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AccountModel getAccountModel() {
        return accountModel;
    }

    public void setAccountModel(AccountModel accountModel) {
        this.accountModel = accountModel;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "name='" + name + '\'' +
                ", accountModel=" + accountModel +
                '}';
    }
}
