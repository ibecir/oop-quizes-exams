package ba.edu.ibu.midterm.db;
/* Write a Java program that connects to a MySQL database and retrieves data from it.
The program should have three methods: getUsersByRole, getUserById, and getUserByName.
The getUsersByRole method should retrieve all users with a given role from the users table,
while the getUserById method should retrieve a single user by their ID.
The getUserByName method should retrieve all users with a name of “Hana” and an ID greater than 2.

DB credidentials:

 CONNECTION_STRING = "jdbc:mysql://oop.ibu.edu.ba:3306/oopgroup1";
 USER: oopuser
 PASSWORD: ooppassWD */



import java.sql.*;
class Question5Group1 {
    private static final String CONNECTION_STRING = "jdbc:mysql://oop.ibu.edu.ba:3306/oopgroup1";
    private static final String USERNAME = "oopuser";
    private static final String PASSWORD = "ooppassWD";

    private Connection connection = null;

    public Question5Group1() {
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void getUsersByRole(String role) throws SQLException {
        PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM users WHERE role = ?");
        statement.setString(1, role);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getString("id"));
            System.out.println(rs.getString("name"));
            System.out.println(rs.getString("role"));
        }
    }

    public void getUserById(int id) throws SQLException {
        PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM users WHERE id = ?");
        statement.setInt(1, id);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getString("id"));
            System.out.println(rs.getString("name"));
            System.out.println(rs.getString("role"));
        }
    }

    public void getUserByName() throws SQLException {
        PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM users WHERE name = ? AND id > ?");
        statement.setString(1, "Hana");
        statement.setInt(2, 2);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getString("id"));
            System.out.println(rs.getString("name"));
            System.out.println(rs.getString("role"));
        }
    }
}

class Main{
    public static void main(String[] args) throws SQLException {
        Question5Group1 db = new Question5Group1();
        db.getUsersByRole("admin");
        db.getUserById(1);
        db.getUserByName();
    }
}