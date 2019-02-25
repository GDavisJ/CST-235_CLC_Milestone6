/**
 * This is the enterprise registration bean.
 * 
 */

package beans;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("cdi-ambiguous-dependency")
@ManagedBean(name="registration")
@SessionScoped
public class EnterpriseRegistration implements Serializable{
	/**Variables are established that will be used for the user submitted data.
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//DAO dao = new DAO();
	protected String userName;
	protected String emailAddress;
	protected String password;
	protected String firstName;
	protected String lastName;
	protected String phoneNumber;
	
	/**A public list is used to store the data and to allow the login module to have 
	*access to the variables for comparison.
	*/
	
	public static List<String> registeredList = new ArrayList<>();

	
	
	public EnterpriseRegistration(String userName, String emailAddress, String passWord, String firstName,
			String lastName) {
		
	}

	/**Traditional getters and setters are used for establishing the variables.
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public void setPassWord(String password) {
		this.password = password;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	public String getUserName() {
		return userName;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	
	public String getPassWord() {
		return password;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
}
