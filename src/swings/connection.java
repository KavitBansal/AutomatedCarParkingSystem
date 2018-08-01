package swings;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;

public class connection {
     static Connection con;
     static Connection doConnect()
     {
    	 try
    	 {
    	 Class.forName("com.mysql.jdbc.Driver");
    	 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/car_parking","root","root");
    	 return con;

    	 }
    	 catch(Exception e)
    	 { 
    		 System.out.println(e); 
    	 }
    	 return null;
    	 }
    	 }
    	 
   