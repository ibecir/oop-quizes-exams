package ba.edu.ibu.midterm;
/*Write a Java program that connects to a MySQL database and retrieves data from it.
The program has three methods: getAnimalsByType, getAnimalById, and getAnimalByName.
The getAnimalsByType method retrieves all animals with a given type from the animals table,
while the getAnimalById method retrieves a single animal by its ID.
The getAnimalByName method retrieves all animals with a name of “Smoki” and an ID greater than 3.

DB credidentials:

 CONNECTION_STRING = "jdbc:mysql://oop.ibu.edu.ba:3306/oopgroup1";
 USER: oopuser
 PASSWORD: ooppassWD
*/

import java.sql.*;

class Question5Group2 {
    private static final String CONNECTION_STRING = "jdbc:mysql://oop.ibu.edu.ba:3306/oopgroup1";
    private static final String USERNAME = "oopuser";
    private static final String PASSWORD = "ooppassWD";

    private Connection connection = null;

    public Question5Group2() {
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void getAnimalsByType(String type) throws SQLException {
        PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM animals WHERE type = ?");
        statement.setString(1, type);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getString("id"));
            System.out.println(rs.getString("name"));
            System.out.println(rs.getString("type"));
        }
    }

    public void getAnimalById(int id) throws SQLException {
        PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM animals WHERE id = ?");
        statement.setInt(1, id);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getString("id"));
            System.out.println(rs.getString("name"));
            System.out.println(rs.getString("type"));
        }
    }

    public void getAnimalByName() throws SQLException {
        PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM animals WHERE name = ? AND id > ?");
        statement.setString(1, "Smoki");
        statement.setInt(2, 2);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getString("id"));
            System.out.println(rs.getString("name"));
            System.out.println(rs.getString("type"));
        }
    }
}

class Main2{
    public static void main(String[] args) throws SQLException {
        Question5Group2 db = new Question5Group2();
        db.getAnimalById(1);
        db.getAnimalByName();
        db.getAnimalsByType("mammal");
    }
}
