package beans;
import java.security.Principal;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import beans.EnterpriseRegistration;


@ManagedBean(name="user")
@ViewScoped
public class User {
	EnterpriseRegistration registration; 
	public String registrationUsername;
	public String registrationPassword;
	public String userName;
	public String password;


	/**Getters and setters are used to establish a username and password.*/
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setRegistrationUsername(String registrationUsername) {
		this.registrationUsername = registrationUsername;
	}
	
	public void setRegistrationPassword(String registrationPassword) {
		this.registrationPassword = registrationPassword;
	}
	
	public String getRegistrationUsername() {
		return registrationUsername;
	}
	
	public String getRegistrationPassword() {
		return registrationPassword;
	}
	public String getUserName() {
		return userName;
	}
	
	public String getPassword() {
		return password;
	}

	
	
	
	
	/**login() method authenticate the user based on the parameters established in the if else statement.
	 * Only the username uses the IgnoreCase for input while the password does not.
	 * Within the faces-config.xml the return of either "success" or "failure" the application redirects 
	 * the user to the appropriate .xhtml page.*/
	public String login() {
		System.out.println(userName + password); 
		if(userName.equalsIgnoreCase(EnterpriseRegistration.registeredList.get(0)) && password.equals(EnterpriseRegistration.registeredList.get(1))){
			System.out.println("SUCCESS!!!!!!!");
			System.out.println(EnterpriseRegistration.registeredList.get(0) + " LIST USERNAME");
			System.out.println(EnterpriseRegistration.registeredList.get(1) + " LIST PASSWORD");
			return "success";
		}
		else {
			return "failure";
		}
	}
	
		
		@PostConstruct 
		public void init() {
			/** Get the logged in Principle*/
			Principal principle= FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
				if(principle == null)
				{
					setUserName("Unknown");
					setPassword("");
				}
				else
				{
					setUserName(principle.getName());
					setPassword("");
				}

		}

}
