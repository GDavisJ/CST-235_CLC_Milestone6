package controllers;

/**Imports needed for functionality.*/
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.RegisterBean;
import database.DAO;
import database.RegisterDao;

@SuppressWarnings("serial")
@WebServlet("/ServletRegistration")
public class ServletRegistration extends HttpServlet {
	DAO dao = new DAO();
	public ServletRegistration() {
		
	 }
	 
	
	 public void onSubmit() {
		 System.out.println("HELLO ServletRegistration.java");
		 
	 }
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 /** Transfers inputs to variables. */
	 System.out.println("HELLO ITS ME");
	 String nickname = request.getParameter("userName");
	 String emailaddress = request.getParameter("emailAddress");
	 String password = request.getParameter("password");
	 String firstname = request.getParameter("firstName");
	 String lastname = request.getParameter("lastName");
	 String phone = request.getParameter("phoneNumber");
	 System.out.println(nickname + emailaddress + password + firstname + lastname + phone + "DATA!!!!!");
	 
	 RegisterBean registerBean = new RegisterBean();
	 /** JavaBeans for similar data.*/
	 registerBean.setNickname(nickname);
	 registerBean.setEmailAddress(emailaddress);
	 registerBean.setPassword(password);
	 registerBean.setFirstName(firstname);
	 registerBean.setLastName(lastname);
	 registerBean.setPhone(phone);
	 
	 System.out.println(registerBean.getFirstName() + "FIRST NAME RIGHT HERE");
	 
	 request.getRequestDispatcher("/MainForm.xhtml").forward(request, response);
	 RegisterDao registerDao = new RegisterDao();
	 
	 /** Registration's core logic for insertion of data into database from user.*/
	 String registerUser = registerDao.registerUser(registerBean);
	 
	 /*if(registerUser.equals("Success")) // Can display successful message on home page.
	 {
		 System.out.println("PLEASE!!!!!!!!!!!");
	 request.getRequestDispatcher("/MainForm.xhtml").forward(request, response);
	 }
	 else // If it fails however it will be noted.
	 {
		 System.out.println("OKAY!!!!!!!!!!!");
	 request.setAttribute("errMessage", registerUser);
	 request.getRequestDispatcher("/Registration.jsp").forward(request, response);
	 }*/
	 }
}
