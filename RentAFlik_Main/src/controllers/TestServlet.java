package controllers;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.EnterpriseRegistration;
import beans.Products;
import database.DAO;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	Products products = new Products();
	DAO dao = new DAO();
	/**Here we gain access to the EJB Registration file where we will be storing the data that was input by the user.*/
    EnterpriseRegistration registration = new EnterpriseRegistration(null, null, null, null, null);
 
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/**These variables are established to hold the data that is brought in from the user in the registration form.*/
		String userName = request.getParameter("userName");
		String emailAddress = request.getParameter("emailAddress");
		String password = request.getParameter("password");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String phoneNumber = request.getParameter("phoneNumber");
		
		/**The EJB is called and sets the variables that were received from the user.*/
		registration.setUserName(userName);
		registration.setEmailAddress(emailAddress);
		registration.setPassWord(password);
		registration.setFirstName(firstName);
		registration.setLastName(lastName);
		registration.setPhoneNumber(phoneNumber);
		
		/**Populating an established list within the registration EJB that will hold the data for the entirety of the session.*/
		EnterpriseRegistration.registeredList.add(userName);
		EnterpriseRegistration.registeredList.add(emailAddress);
		EnterpriseRegistration.registeredList.add(password);
		EnterpriseRegistration.registeredList.add(firstName);
		EnterpriseRegistration.registeredList.add(lastName);
		EnterpriseRegistration.registeredList.add(phoneNumber);
		try {
			dao.insertUser(userName, emailAddress, password, firstName, lastName, phoneNumber);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CheckRegistration();
	
		/**The MainForm page is displayed upon the user fully submitting their data within the registration form. Currently the page
		 * doesn't load the main content properly, but the header and footer are available allowing the user to navigate to the login
		 * page to properly login with their submitted data.*/
		request.getRequestDispatcher("/MainForm.xhtml").forward(request, response);
	}
	public String allProductsPage() {
		return "AllProducts.xhtml";
	}
	
	/**CheckRegistration() is called at the end of the data being submitted by the user and will be compared against null values or empty strings.
	 * If the user left any fields blank a message will be displayed in the console asking them to return to the registration page and resubmit the data.*/
	public String CheckRegistration(){
		if(registration.getUserName().equals(null)|| registration.getUserName().equals("") && registration.getEmailAddress().equals(null)|| registration.getEmailAddress().equals("")
				&& registration.getPassWord().equals(null)|| registration.getPassWord().equals("") && registration.getFirstName().equals(null)|| registration.getFirstName().equals("")
				&& registration.getLastName().equals(null)|| registration.getLastName().equals("")){
			System.out.println("PLEASE REREGISTER YOUR DATA. VARIOUS FIELDS WERE MISSED");
			return "failed";
		}
		else {
			return "successful";
		}
	}	
}