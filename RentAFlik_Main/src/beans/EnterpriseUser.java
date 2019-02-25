package beans;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

/**
 * Session Bean implementation class EnterpriseUser
 */
@Alternative
@Stateless
@Local
@LocalBean
public class EnterpriseUser implements Serializable  {

	/**
	 * Variables are established that will be used for the user submitted data.
	 */
	private static final long serialVersionUID = 1L;
	EnterpriseRegistration registration;
	protected String userName;
	protected String password;
	public static List<String> registeredList = new ArrayList<>();
	
	/**
	 * Tradition getters and setters are used for establishing the variables.
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getPassword() {
		return password;
	}

	/**Method of comparing the user inputs to those of the data that was input during the registration form.
	*If the username and password are the same the application redirects the user into the main page, while if the check fails
	*it will redirect the user to the appropriate failed .xhtml page.
	*/
	public String login() throws SQLException {
		if(userName.equalsIgnoreCase(EnterpriseRegistration.registeredList.get(0)) && password.equals(EnterpriseRegistration.registeredList.get(1))) {
			return "success";
		}
		else {
			return "failure";
		}
	}
    public EnterpriseUser() {

    }
}
