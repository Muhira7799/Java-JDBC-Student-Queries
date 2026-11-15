import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCStudents {

    public static void main(String[] args) {

        try {

            // Connect to MySQL database
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/University",
                    "root",
                    ""
            );

            // Create statement
            Statement stmt = con.createStatement();

            // i. Display all LName started by J
            System.out.println("LName started by J:");

            ResultSet rs = stmt.executeQuery(
                    "SELECT * FROM students WHERE LName LIKE 'J%'"
            );

            while (rs.next()) {
                System.out.println(
                        rs.getInt("Id") + " " +
                        rs.getString("LName") + " " +
                        rs.getString("Course") + " " +
                        rs.getString("Country")
                );
            }

            // ii. Display all countries started by R
            System.out.println("\nCountries started by R:");

            rs = stmt.executeQuery(
                    "SELECT * FROM students WHERE Country LIKE 'R%'"
            );

            while (rs.next()) {
                System.out.println(
                        rs.getInt("Id") + " " +
                        rs.getString("LName") + " " +
                        rs.getString("Course") + " " +
                        rs.getString("Country")
                );
            }

            // iii. Display all information of Id 2012
            System.out.println("\nInformation of Id 2012:");

            rs = stmt.executeQuery(
                    "SELECT * FROM students WHERE Id = 2012"
            );

            while (rs.next()) {
                System.out.println(
                        rs.getInt("Id") + " " +
                        rs.getString("LName") + " " +
                        rs.getString("Course") + " " +
                        rs.getString("Country")
                );
            }

            // iv. Display all IT courses
            System.out.println("\nIT courses:");

            rs = stmt.executeQuery(
                    "SELECT * FROM students WHERE Course = 'IT'"
            );

            while (rs.next()) {
                System.out.println(
                        rs.getInt("Id") + " " +
                        rs.getString("LName") + " " +
                        rs.getString("Course") + " " +
                        rs.getString("Country")
                );
            }

            // Close connection
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}