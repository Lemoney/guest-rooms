package api;

import entity.User;

import java.util.List;

public interface UserService {


    void addUser(User user);

    void removeUserById(int id);
    User getUserById(int id);
    User getUserByLogin(String login);

    void updateUserByLogin(String login);

    List<User> getAllUsers();
}
