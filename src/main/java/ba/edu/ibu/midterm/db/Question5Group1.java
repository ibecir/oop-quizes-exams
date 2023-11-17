package ba.edu.ibu.midterm.db;
/* Write a Java program that connects to a MySQL database and retrieves data from it.
The program should have a method getUsers that takes 2 parameters name, and id.
The method should retrieve all users with a name of “Becir” and an ID greater than 2.

 Example of connection string:"jdbc:mysql://HOSTNAME:3306/DB_NAME";
 USERNAME: oopuser
 PASSWORD: ooppassWD
 HOSTNAME: oop.ibu.edu.ba
 DB_NAME: oopgroup1

*/

import java.sql.*;
class Question5Group1 {
    // Example of connection string: "jdbc:mysql://HOSTNAME:3306/DB_NAME"
    private static final String CONNECTION_STRING = "jdbc:mysql://oop.ibu.edu.ba:3306/DBNAME";
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

    public void getUsers(String name, int id) throws SQLException {
        PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM users WHERE name = ? AND id > ?");
        statement.setString(1, name);
        statement.setInt(2, id);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getString("id"));
            System.out.println(rs.getString("name"));
        }
    }
}

class Main{
    public static void main(String[] args) throws SQLException {
        Question5Group1 db = new Question5Group1();
        db.getUsers("Becir", 10);
    }
}