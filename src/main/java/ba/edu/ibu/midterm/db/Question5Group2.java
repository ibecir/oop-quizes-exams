package ba.edu.ibu.midterm.db;
/*Write a Java program that connects to a MySQL database and retrieves data from it.
The program has method getAnimal that  has one parameter name.
The method retrieves all animals with a name of “Smoki” and an ID greater than 3.

 Example of connection string:"jdbc:mysql://HOSTNAME:3306/DB_NAME";
 USERNAME: oopuser
 PASSWORD: ooppassWD
 HOSTNAME: oop.ibu.edu.ba
 DB_NAME: oopgroup2

*/

import java.sql.*;

class Question5Group2 {
    private static final String CONNECTION_STRING = "jdbc:mysql://oop.ibu.edu.ba:3306/oopgroup2";
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



    public void getAnimals(String name, int id) throws SQLException {
        PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM animals WHERE name = ? AND id > ?");
        statement.setString(1, name);
        statement.setInt(2, id);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getString("id") + "->" + rs.getString("name") + "->" + rs.getString("type"));
        }
    }
}

class Main2{
    public static void main(String[] args) throws SQLException {
        Question5Group2 db = new Question5Group2();
        db.getAnimals("Smoki", 2); // treba da vrati 6, Smoki, cat
        db.getAnimals("Mum", 2); // treba da vrati 6, Smoki, cat
    }
}
