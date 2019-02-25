/**This class will be used to create the product object*/

package beans;
import javax.validation.constraints.*;
//This is the product creation class.
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="product")
public class Product {
	
	/**
	 * These are the product variables 
	 */
	@NotNull(message = "Field cannot be null")
	int id;
	@NotNull(message = "Field cannot be null")
	String title;
	@NotNull(message = "Field cannot be null")
	String genre;
	@NotNull(message = "Field cannot be null")
	String leadAct;
	@NotNull(message = "Field cannot be null")
	String studio;
	@NotNull(message = "Field cannot be null")
	String director;
	@NotNull(message = "Field cannot be null")
	int length;
	@NotNull(message = "Field cannot be null")
	int year;
	@NotNull(message = "Field cannot be null")
	double price;
	@NotNull(message = "Field cannot be null")
	String vidImg;
	
	/**Constructors */
	public Product() {
		this.id = 0;
		this.title = "";
		this.genre = "";
		this.leadAct = "";
		this.studio = "";
		this.director = "";
		this.length = 0;
		this.year = 0;
		this.price = 3.5;
		this.vidImg = "ComingSoon.PNG";
		
	}
	
	public Product(int id,String title, String genre, String leadAct, String studio, String director,
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
