
import java.sql.*;

public class Main{
    private static final String url="jdbc:mysql://127.0.0.1:3306/demo";
    private static final String User="root";
    private static final String password="prashant@123";
    public static void main(String[]arg)
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
        }

        try{
            Connection connection = DriverManager.getConnection(url,User , password);
            Statement statement = connection.createStatement();
            String Query = "SELECT * FROM student";
            ResultSet resultset = statement.executeQuery(Query);

            while(resultset.next())
            {
                int id = resultset.getInt("id");
                String name = resultset.getString("name");
                int age = resultset.getInt("age");
                double marks = resultset.getDouble("marks");

                System.out.println("id:"+id);
                System.out.println("name:"+name);
                System.out.println("age:"+age);
                System.out.println("marks:"+marks);
            }
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}