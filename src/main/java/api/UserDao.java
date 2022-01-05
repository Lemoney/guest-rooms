package api;

import entity.User;

import java.util.List;

public interface UserDao {

    void saveUser(User user);

    void removeUserById(int id);
    void removeUserByLogin(String login);

    List<User> getAllUsers();

    void changePassword(User user, String newPassword);

    void changeRole(User user, String newRole);
}
