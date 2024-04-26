
import java.sql.*;

public  class Main{
    private static final String name="root";
    private static final String Url="jdbc:mysql://127.0.0.1:3306/demo";
    private  static final String Password="prashant@123";
    public  static void main(String[]arg)
    {
       try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           System.out.println("Driver added in Driver Manager class");
       }
       catch (ClassNotFoundException e)
       {
           System.out.println(e.getMessage());
       }


       try{
           Connection connection =DriverManager.getConnection(Url,name,Password);
           String query ="INSERT INTO STUDENT(name,age,marks) VALUES(?,?,?)";
           PreparedStatement preparedstatement = connection.prepareStatement(query);
           preparedstatement.setString(1,"Rohit");
           preparedstatement.setInt(2,24);
           preparedstatement.setDouble(3,66.7);
           int rows_effect = preparedstatement.executeUpdate();
           if(rows_effect>0)
           {
               System.out.println("Data Inserted");
           }
           String query2="SELECT * FROM STUDENT";
           PreparedStatement selectquery = connection.prepareStatement(query2);
           ResultSet resultset = selectquery.executeQuery();
           while(resultset.next())
           {
               System.out.println("Id:"+resultset.getInt("id"));
               System.out.println("name:"+resultset.getString("name"));
           }
           preparedstatement.close();
           connection.close();
       }
       catch (SQLException e)
       {
        System.out.println(e.getMessage());
       }
    }
}