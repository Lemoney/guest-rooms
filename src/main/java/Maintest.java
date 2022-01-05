import dao.UserDaoImpl;
import entity.User;
import entity.enums.Roles;

public class Maintest {
    public static void main(String[] args) {
        UserDaoImpl userDao = new UserDaoImpl();
//        userDao.saveUser(new User("login1", "password", Roles.ADMIN));
//        userDao.saveUser(new User("login2", "password", Roles.GUEST));

//        userDao.removeUserById(1);
//        userDao.removeUserByLogin("login1");
        User user1 = new User("login5", "password", Roles.ADMIN);
//        userDao.saveUser(user1);
        System.out.println(userDao.getAllUsers());
        userDao.changePassword(user1, "password123");
        System.out.println(userDao.getAllUsers());
        userDao.changeRole(user1, "guest");
        System.out.println(userDao.getAllUsers());
    }
}
