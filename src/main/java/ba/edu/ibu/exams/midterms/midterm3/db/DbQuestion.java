package ba.edu.ibu.exams.midterms.midterm3.db;

import java.sql.*;

class DbQuestion {
    private static final String CONNECTION_STRING = "jdbc:mysql://oop.ibu.edu.ba:3306/oopgroup2?allowPublicKeyRetrieval=true&useSSL=false";
    private static final String USERNAME = "oopuser";
    private static final String PASSWORD = "ooppassWD";

    private Connection connection = null;

    public DbQuestion() {
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

class Main2 {
    public static void main(String[] args) throws SQLException {
        DbQuestion db = new DbQuestion();
        db.getAnimals("Smoki", 2); // treba da vrati 6, Smoki, cat
        db.getAnimals("Mum", 2); // treba da vrati 6, Smoki, cat
    }
}
