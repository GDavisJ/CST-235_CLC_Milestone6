package beans;
import javax.faces.bean.*;

@ManagedBean
@ViewScoped
public class NewUser {

	public String firstName;
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return firstName;
	}
}
