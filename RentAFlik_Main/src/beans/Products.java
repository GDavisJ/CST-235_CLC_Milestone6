package beans;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.*;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import database.DAO;


@ManagedBean(name="productss", eager = true) 
@SessionScoped
@SuppressWarnings("unused")
public class Products implements Serializable{
	private static final long serialVersionUID = 1L;
	@Inject
	private business.ProductsBusinessInterface service;
	EnterpriseUser user;
	int id;
	String title;
	String genre;
	String leadAct;
	String studio;
	String director;
	int length;
	int year;
	double price = 3.5;
	String vidImg;
	public int testInput;
	public List<Product> productss = new ArrayList<>();

    /**
     * Default constructor. 
     */
    public Products() {
    	productss.add(new Product(1,"Dr. Seuss' The Grinch","Family","Benedict Cumberbatch","Illumination", "Yarrow Cheney", 90, 2019, 3.55, "TheGrinch.PNG"));
    	productss.add(new Product(2,"Robin Hood","Action","Taron Egerton","Lionsgate", "Otto Bathurst", 116, 2018, 3.55, "RobinHood.PNG"));
    	productss.add(new Product(3,"Ready Player One","Action","Tye Sheridan","Warner", "Steven Spielberg", 140, 2018, 3.55, "ReadyPlayerOne.PNG"));
    	productss.add(new Product(4,"Avengers: Infinity War","Action","Chris Hemsworth","BVHE", "Anthony Russo", 149, 2018, 3.55, "AvengersInfinityWar.PNG"));
    	productss.add(new Product(5,"The Lego Batman Movie","Family","Will Arnett","Warner", "Chris McKay", 124, 2017, 3.55, "LegoBatman.PNG"));
    	productss.add(new Product(6,"Johnny English Strikes Again","Comedy","Rowan Atkinson","Universal", "David Kerr", 88, 2019, 3.55, "JohnnyEnglish.PNG"));
    	productss.add(new Product(7,"Venom","Action","Tom Hardy","Sony", "Ruben Fleischer", 112, 2018, 3.55, "Venom.PNG"));
    	productss.add(new Product(8,"The Predator","Action","Boyd Holbrook","Fox", "Shane Black", 107, 2018, 3.55, "Predator.PNG"));
    }
	public Products(int id, String title, String genre, String leadAct, String studio, String director,
			int length, int year, double price, String vidImg) {
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.leadAct = leadAct;
		this.studio = studio;
		this.director = director;
		this.length = length;
		this.year = year;
		this.price = price;
		this.vidImg = vidImg;
		
	}
	
	/**Method adds the project object from the form to a product list. 
	 * This list will be used to build the form table */
	public String addProd(ProductUser prod) throws SQLException{
        Product product = new Product(prod.getId(),prod.getTitle(),prod.getGenre(),prod.getLeadAct(),prod.getStudio(),prod.getDirector(),prod.getLength(),prod.getYear(),prod.getPrice(),prod.getVidImg());
        productss.add(product);
        service.setProducts(productss);
        DAO dao = new DAO(productss);
        return "AllProducts.xhtml?faces-redirect=true";
    }
    
	
	/**Method adds the project object from the form to a product list. 
	 * This list will be used to build the form table*/
	public String addProd(Products prod) throws SQLException{
        Product product = new Product(prod.getId(),prod.getTitle(),prod.getGenre(),prod.getLeadAct(),prod.getStudio(),prod.getDirector(),prod.getLength(),prod.getYear(),prod.getPrice(),prod.getVidImg());
        productss.add(product);
        service.setProducts(productss);
        DAO dao = new DAO(productss);
        return "added";
    }
	
	/**The search bar within the application compares against two of the product ID's. 
	 * If either search correctly passes then the console will output the appropriate
	 * product information based on the product ID that was established.*/
	public String searchTest() throws SQLException {
		if (testInput <= productss.size()) {
			System.out.println("Movie ID:" + productss.get(testInput).getId() + " Movie Title:"+ productss.get(testInput).getTitle() + " Movie Genre:" + productss.get(testInput).getGenre()
				+ " Lead Actor:" + productss.get(testInput).getLeadAct() + " Movie Studio:" + productss.get(testInput).getStudio() + " Movie Director:" + productss.get(testInput).getDirector()
				+ " Length:" + productss.get(testInput).getLength() + " Release Year:" + productss.get(testInput).getYear() + " Rental Price:$" + productss.get(testInput).getPrice());
		}
		
		else {
			System.out.println("Invalid ID");
		}
		return "Search.xhtml";
	}

	
	public Product getSearchProd() {
		if (testInput < productss.size()) {
			return productss.get(testInput);
		}
		
		else {
			System.out.println("Invalid ID");
			return null;
		}

	}
	
	/**Establishes the search variable with a getter and setter.*/
	public void setTestInput(int testInput) {
		this.testInput = testInput;
	}
	
	public int getTestInput() {
		return testInput;
	}
	
	/**This method returns the product list*/
	public List<Product> getProductss() {
		return productss;
	}
	
	/**Deletes the project object and updates the DAO*/
	public void deleteMovie(ActionEvent evt) {
		HtmlDataTable table = getParentDataTable((UIComponent)evt.getSource());
		//Object o = table.getRowData();
		int index = table.getRowIndex();
		System.out.println("I've got the row index " + index);
		try {
			productss.remove(index);
			
			DAO dao = new DAO(productss);
		} catch (SQLException e) {
			System.out.println("The table is empty");
		}
		//return "AllProducts.xhtml?faces-redirect=true";
	}
	

	/**Edit the product object and updates the DAO*/
	public void editMovie(ActionEvent evt) {
		HtmlDataTable table = getParentDataTable((UIComponent)evt.getSource());
		Object o = table.getRowData();
		
		System.out.println(o.toString());
		int index = table.getRowIndex();

		System.out.println("I've got the row index " + index);
		this.id = productss.get(index).getId();
		this.title = productss.get(index).getTitle();
		this.genre = productss.get(index).getGenre();
		this.leadAct = productss.get(index).getLeadAct();
		this.studio = productss.get(index).getStudio();
		this.director = productss.get(index).getDirector();
		this.length = productss.get(index).getLength();
		this.year = productss.get(index).getYear();
		this.price = productss.get(index).getPrice();
		this.vidImg = productss.get(index).getVidImg();
		try {
			productss.remove(index);
			
			DAO dao = new DAO(productss);
		} catch (SQLException e) {
			System.out.println("The table is empty");
		}
		//return "EditProduct.xhtml?faces-redirect=true";
	}	
	

	
/*	//Deletes the project object and updates the DAO
	public void testMovie(ActionEvent evt) {
		//HtmlDataTable table = getParentDataTable((UIComponent)evt.getSource());
		System.out.println(evt.getSource().toString());
		HtmlCommandButton bttn = (HtmlCommandButton) evt.getComponent();
		System.out.println(bttn.getId());
		bttn.getTabindex();
		System.out.println(bttn.getLabel());


		//Object o = table.getRowData();
		//int index = table.getRowIndex();
		System.out.println("I've got the row index ");
		
		//return "AllProducts.xhtml?faces-redirect=true";
	}*/
	
	//Deletes the project object and updates the DAO
		public String testMovie() {
			
			return "AllProducts.xhtml?faces-redirect=true";
		}
	
	
	private HtmlDataTable getParentDataTable(UIComponent compo) {
		if (compo == null) {
			return null;
		}
		if (compo instanceof HtmlDataTable) {
			return (HtmlDataTable) compo;
		}
		return getParentDataTable(compo.getParent());
	}

	
	/**Getters and Setters*/
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public String getGenre() {
		return genre;
	}	
	public void setLeadAct(String leadAct) {
		this.leadAct = leadAct;
	}
	
	public String getLeadAct() {
		return leadAct;
	}	

	public void setStudio(String studio) {
		this.studio = studio;
	}
	
	public String getStudio() {
		return studio;
	}
	
	public void setDirector(String director) {
		this.director = director;
	}
	
	public String getDirector() {
		return director;
	}
	
	public void setLength(int length) {
		this.length = length;
	}
	
	public int getLength() {
		return length;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setVidImg(String vidImg) {
		this.vidImg = vidImg;
	}
	
	public String getVidImg() {
		return vidImg;
	}
}
