import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;

public class Main {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/demo";
    private static final String user = "root";
    private static final String password = "prashant@123";

    public static void main(String[] arg) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            String name = "Rohit";
            int age = 21;
            float marks = 43.5f;
            String query = String.format("UPDATE student SET marks=%f WHERE id=%d",99.9 , 2);
            int rowAffected = statement.executeUpdate(query);
            if (rowAffected > 0) {
                System.out.println("Data is Inserted");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}