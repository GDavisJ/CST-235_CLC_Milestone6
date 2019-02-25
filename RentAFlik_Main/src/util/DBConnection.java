package util;

/**Imports needed for functionality.*/
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

public static Connection createConnection()
{
Connection connection = null;
String URLaddress = "jdbc:mysql://localhost:3306/customers"; // Database name follows the URL for MySQL.
String username = "root"; // The username for MySQL.
String password = "root123"; // The password for MySQL.

try 
{
try 
{
Class.forName("com.mysql.jdbc.Driver"); // MySQL drivers are loaded here. 
} 
catch (ClassNotFoundException e)
{
e.printStackTrace();
}

connection = DriverManager.getConnection(URLaddress, username, password); // Connects to database.
System.out.println("Now displaying the connecting object " + connection);
} 
catch (Exception e) 
{
e.printStackTrace();
}

return connection; 
}
}
