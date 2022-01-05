package entity;

import entity.enums.Roles;

public class User {
    private int ID;
    private String login;
    private String password;
    private Roles role;

    public User(String login, String password, Roles role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public User(int ID, String login, String password, Roles role) {
        this.ID = ID;
        this.login = login;
        this.password = password;
        this.role = role;
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

    public Roles getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "\nID=" + ID +
                ", login: " + login +
                ", password: " + password +
                ", role: " + role;
    }
}
