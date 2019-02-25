package business;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.*;
import beans.*;
import database.DAO;

/**
 * Session Bean implementation class OrdersBusinessService
 */
@Stateless
@Local(ProductsBusinessInterface.class)
@LocalBean
@Alternative 

public class ProductsBusinessService implements ProductsBusinessInterface {
	private List<Product> products = new ArrayList<Product>();
	
    /**Constructor that adds testing objects to the orders list*/
    public ProductsBusinessService() {

    }

    /**Setters and Getters*/
	@Override
	public List<Product> getProducts() {
		return products;
	}

	@Override
	public void setProducts(List<Product> products) {
		this.products = products;
		
	}

	/** This method clears the object list and database*/
	@Override
	public List<Product> deleteProducts() {
		this.products.clear();
		try {
			@SuppressWarnings("unused")
			DAO dao = new DAO(products);
			System.out.println("Database Cleared!!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this.products;
		
	}

}
