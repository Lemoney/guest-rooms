package dao;

import api.UserDao;
import entity.User;
import entity.enums.Roles;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class UserDaoImpl implements UserDao {

    private Connection connection;


    String database = "pokoje_goscinne";
    String tableName = "users";
    String user = "root";
    String password = "password123$";

    public UserDaoImpl() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/"+database+"?useSSL=false", user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveUser(User user) {
        PreparedStatement statement;

        String query = "INSERT INTO " + tableName + "(login, password, role) VALUES(?, ?, ?)";

        try {
            statement = connection.prepareStatement(query);

            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getRole().toString());

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeUserById(int id) {
        PreparedStatement statement;

        String query = "DELETE FROM " + tableName + " WHERE ID = ?";

        try {
            statement = connection.prepareStatement(query);

            statement.setInt(1, id);

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeUserByLogin(String login) {
        PreparedStatement statement;

        String query = "DELETE FROM " + tableName + " WHERE login = ?";

        try {
            statement = connection.prepareStatement(query);

            statement.setString(1, login);

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void changePassword(User user, String newPassword) {
        PreparedStatement statement;

        String query = "UPDATE " + tableName + " SET password= ? WHERE login = ?";

        try {
            statement = connection.prepareStatement(query);

            statement.setString(1, newPassword);
            statement.setString(2, user.getLogin());

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void changeRole(User user, String newRole) {
        PreparedStatement statement;

        String query = "UPDATE " + tableName + " SET role = ? WHERE login = ?";

        try {
            statement = connection.prepareStatement(query);

            statement.setString(1, newRole.toUpperCase(Locale.ROOT));
            statement.setString(2, user.getLogin());

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<User> getAllUsers() {
        List<User> users = new LinkedList<>();
        Statement statement;

        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM " + tableName;
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                String userRole = resultSet.getString("role");
                users.add(new User(id, login, password, Roles.valueOf(userRole.toUpperCase(Locale.ROOT))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
