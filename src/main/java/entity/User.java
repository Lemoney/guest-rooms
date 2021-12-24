package entity;

public class User {
    private int ID;
    private String login;
    private String password;
    private boolean administrator;

    public User(int ID, String login, String password, boolean administrator) {
        this.ID = ID;
        this.login = login;
        this.password = password;
        this.administrator = administrator;
    }

    public int getID() {
        return ID;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAdministrator() {
        return administrator;
    }
}
