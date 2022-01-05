package dao;

import api.RoomDao;
import entity.Room;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class RoomDaoImpl implements RoomDao {

    //Przetestuj czy wszystko ok

    private Connection connection;


    String database = "pokoje_goscinne";
    String tableName = "rooms";
    String user = "root";
    String password = "password123$";

    public RoomDaoImpl() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/"+database+"?useSSL=false", user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Room> getAllRooms() {
        List<Room> rooms = new LinkedList<>();
        Statement statement;

        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM " + tableName;
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String roomNumber = resultSet.getString("room_number");
                int singleBeds = resultSet.getInt("single_beds");
                int doubleBeds = resultSet.getInt("double_beds");
                boolean balcony = resultSet.getBoolean("balcony");
                rooms.add(new Room(roomNumber, singleBeds, doubleBeds, balcony));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rooms;
    }

    @Override
    public void saveRoom(Room room) {
        PreparedStatement statement;

        String query = "INSERT INTO " + tableName + "(room_number, single_beds, double_beds, balcony)"
                        + " VALUES (?, ?, ?, ?)";

        try {
            statement = connection.prepareStatement(query);

            statement.setString(1, room.getRoomNumber());
            statement.setInt(2, room.getSingleBeds());
            statement.setInt(3, room.getDoubleBeds());
            statement.setBoolean(4, room.isBalcony());

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeRoomByRoomNumber(int roomNumber) {
        PreparedStatement statement;

        String query = "DELETE FROM " + tableName + " WHERE room_number = ?";

        try {
            statement = connection.prepareStatement(query);

            statement.setInt(1, roomNumber);
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void changeNumberOfSingleBeds(String roomNumber, int newNumberOfSingleBeds) {
        PreparedStatement statement;

        String query = "UPDATE " + tableName + " SET single_beds = ? WHERE room_number = ?";

        try {
            statement = connection.prepareStatement(query);

            statement.setInt(1, newNumberOfSingleBeds);
            statement.setString(2, roomNumber);

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void changeNumberOfDoubleBeds(String roomNumber, int newNumberOfDoubleBeds) {
        PreparedStatement statement;

        String query = "UPDATE " + tableName + " SET double_beds = ? WHERE room_number = ?";

        try {
            statement = connection.prepareStatement(query);

            statement.setInt(1, newNumberOfDoubleBeds);
            statement.setString(2, roomNumber);

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
