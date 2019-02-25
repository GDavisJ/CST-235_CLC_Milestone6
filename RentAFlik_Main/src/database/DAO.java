package database;

import java.sql.*;
import java.util.List;

import beans.Product;
import beans.Products;

public class DAO {
	
	Products products = new Products();
	public List<Product> newProductss;
	
	public DAO() {
	
	}
	
	public DAO(List<Product> newList) throws SQLException {
		newProductss = newList;
		insertProduct(newProductss);
	}
	
	//Method of deleting the database has been left in place in the event that it will be needed as a separate 
	//method later in the project.
	/*public void deleteAllProducts() throws SQLException{
		Connection conn = null;
		String sqlUserName = "postgres";
		String sqlPassword = "Movieman16";
		Statement sqlStatement = null;
		String query = "DELETE FROM public.PRODUCTS";
			try {
				conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", sqlUserName, sqlPassword);
				sqlStatement = conn.createStatement();
				//sqlStatement.executeUpdate(query);
				PreparedStatement preparedStmt = conn.prepareStatement(query);
				preparedStmt.execute();
				preparedStmt.close();
				conn.close();
			}finally {
				conn.close();
			}
	}*/
	
	public void getAllProducts() throws SQLException{
		/**Variables for this method are established to display in the console the data that has been
		 * retrieved from the database.*/
		int movieID;
		String movieTitle;
		String movieGenre;
		String movieActor;
		String movieStudio;
		String movieDirector;
		int movieYear;
		float price;
		
		/**Variables are established for the connection, username, password, and the sqlStatement. 
		 * All of these variables are initialized and utilized within the method.*/
		Connection conn = null;
		String sqlUserName = "postgres";
		String sqlPassword = "password";
		Statement sqlStatement = null;
		/**sqlString is used as a query tool to retrieve the data from within the database.*/
		String sqlString = "SELECT * FROM public.PRODUCTS";
		try {
			/**A connection is made to the database utilizing the proper URL, username, and password.*/
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", sqlUserName, sqlPassword);
			sqlStatement = conn.createStatement();
			/**The result set is used to initialize the variables to the data that was retrieved allow 
			 * us to output that data into the console for each column within the tables of the database.*/
			ResultSet rs = sqlStatement.executeQuery(sqlString);
			while(rs.next()) {
				movieID = rs.getInt("ID");
				movieTitle = rs.getString("PRODUCT_TITLE");
				movieGenre = rs.getString("PRODUCT_GENRE");
				movieActor = rs.getString("PRODUCT_LEADACT");
				movieStudio = rs.getString("PRODUCT_STUDIO");
				movieDirector = rs.getString("PRODUCT_DIRECTOR");
				movieYear = rs.getInt("PRODUCT_YEAR");
				price = rs.getFloat("PRICE");
				System.out.println("ID" + movieID + "Movie Title: " + movieTitle + " Movie Genre: " + movieGenre + "Lead Actor: " + movieActor 
						+ " Movie Studio: "+ movieStudio + " Movie Director: " + movieDirector + " Year of Release: " + movieYear + " Rental Price: "+ price);
			}
		}finally {
			/**The connection to the database is closed upon completing the method.*/
			conn.close();
		}
	}
	
	public void insertProduct(List<Product> newProductss) throws SQLException{

		/**Variables are established to hold data from the products list that will be
		 * input into the database.*/
		int movieID;
		String movieTitle;
		String movieGenre;
		String movieActor;
		String movieStudio;
		String movieDirector;
		int movieYear;

		Connection conn = null;
		String sqlUserName = "postgres";
		String sqlPassword = "password";
		Statement sqlStatement = null;
		/**The query string is used as a query tool to place data into the database.*/
		String query = "INSERT INTO public.PRODUCTS(ID,PRODUCT_TITLE, PRODUCT_GENRE, PRODUCT_LEADACT, PRODUCT_STUDIO, PRODUCT_DIRECTOR, PRODUCT_YEAR, PRICE) VALUES(?,?,?,?,?,?,?,3.50)";
		/**The deleteQuere is used as a query tool to delete the data from within the database and 
		 * will be followed by inputing the new data.*/
		String deleteQuery = "DELETE FROM public.PRODUCTS";
		try {
			/**A connection is made to the database utilizing the proper URL, username, and password.*/
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", sqlUserName, sqlPassword);
			sqlStatement = conn.createStatement();
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			PreparedStatement deleteStatement = conn.prepareStatement(deleteQuery);
			deleteStatement.execute();
			/**A for loop is utilized to iterate through all the products within the list and assigns variables to each
			 * data piece. The data is then placed into the database.*/
			for(int i = 0; i < newProductss.toArray().length; i++) {
				movieID = newProductss.get(i).getId();
				preparedStmt.setInt(1, movieID);
				movieTitle = newProductss.get(i).getTitle();
				preparedStmt.setString(2, movieTitle);
				movieGenre = newProductss.get(i).getGenre();
				preparedStmt.setString(3, movieGenre);
				movieActor = newProductss.get(i).getLeadAct();
				preparedStmt.setString(4, movieActor);
				movieStudio = newProductss.get(i).getStudio();
				preparedStmt.setString(5, movieStudio);
				movieDirector = newProductss.get(i).getDirector();
				preparedStmt.setString(6, movieDirector);
				movieYear = newProductss.get(i).getYear();
				preparedStmt.setInt(7, movieYear);
				preparedStmt.execute();
			}
			/**Both statements are closed upon completion along with the connection to the database.*/
			deleteStatement.close();
			sqlStatement.close();
			conn.close();
		}
		finally {
			/**Get all products is called upon creating the new database to read into the console.*/
			getAllProducts();
			sqlStatement.close();
			conn.close();
		}
	}
	
	public void insertUser(String userName, String emailAddress, String password,
			String firstName, String lastName, String phoneNumber) throws SQLException{

		/**Variables are established to hold data from the products list that will be
		 * input into the database.*/
		Connection conn = null;
		String sqlUserName = "postgres";
		String sqlPassword = "password";
		Statement sqlStatement = null;
		/**The query string is used as a query tool to place data into the database.*/
		String query = "INSERT INTO public.users(USER_ID,PASSWORD, FNAME, LNAME, EMAIL, PHONE) VALUES(?,?,?,?,?,?)";
		try {
			/**A connection is made to the database utilizing the proper URL, username, and password.*/
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", sqlUserName, sqlPassword);
			sqlStatement = conn.createStatement();
			PreparedStatement preparedStmt = conn.prepareStatement(query);

			/**A for loop is utilized to iterate through all the products within the list and assigns variables to each
			 * data piece. The data is then placed into the database.*/
			preparedStmt.setString(1, userName);
			preparedStmt.setString(2, password);
			preparedStmt.setString(3, firstName);
			preparedStmt.setString(4, lastName);
			preparedStmt.setString(5, emailAddress);
			preparedStmt.setString(6, phoneNumber);
			preparedStmt.execute();
			
			/**Both statements are closed upon completion along with the connection to the database.*/
			preparedStmt.close();
			sqlStatement.close();
			conn.close();
		}
		finally {
			sqlStatement.close();
			conn.close();
		}
	}
}

