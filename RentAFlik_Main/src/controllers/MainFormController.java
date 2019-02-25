package controllers;

import java.io.IOException;
import java.util.Map;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.EnterpriseRegistration;
import business.ProductsBusinessInterface;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class MainFormController extends HttpServlet {
	@Inject
	private business.ProductsBusinessInterface service;
	EnterpriseRegistration enterpriseRegistration;
	public MainFormController() {
		System.out.println("HELLO MainFormController");
	}
	
	/**get the information from the service*/
	public  ProductsBusinessInterface getService() {
		return service;
	}
	
	public String onLogoff() {
		/** Invalidate the Session to clear the security token*/
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		/** Redirect to a protected page (so we get a full HTTP Request) to get Login Page*/
		return "MainForm.xhtml?faces-redirect=true";
	}
	
	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HELLO IT'S ME");
		String userName = request.getParameter("userName");
		String emailAddress = request.getParameter("emailAddress");
		String password = request.getParameter("password");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		
		request.getRequestDispatcher("/MainForm.xhtml").forward(request, response);
	}
	/*public void getData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		System.out.println(userName);
	}*/
}
