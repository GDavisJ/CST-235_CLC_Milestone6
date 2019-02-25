package database;
/**This is the Register DAO*/
/**Imports needed for functionality.*/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import beans.RegisterBean;
import util.DBConnection;

public class RegisterDao {

public String registerUser(RegisterBean registerBean)
{
/** Applying all variables needed for registration.*/
String nickname = registerBean.getNickname();
String emailaddress = registerBean.getEmailAddress();
String password = registerBean.getPassword();
String firstname = registerBean.getFirstName();
String lastname = registerBean.getLastName();
String phone = registerBean.getPhone();


Connection connection = null; // From DBConnection.

PreparedStatement preparedStatement = null;

try
{
connection = DBConnection.createConnection();
String query = "insert into users(SlNo,nickname,EmailAddress,password,firstName,lastName,phone) values (NULL,?,?,?,?,?,?)"; //Insert user details into the table 'USERS'
preparedStatement = connection.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
preparedStatement.setString(1, nickname);
preparedStatement.setString(2, emailaddress);
preparedStatement.setString(3, password);
preparedStatement.setString(4, firstname);
preparedStatement.setString(5, lastname);
preparedStatement.setString(6, phone);

int i = preparedStatement.executeUpdate();

if (i != 0) // Data insurance.
return "Success"; 
}
catch(SQLException e)
{
e.printStackTrace();
}

return "An error has occurred."; // Failure message. 
}
}

