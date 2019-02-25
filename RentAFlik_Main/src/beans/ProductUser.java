package beans;
import javax.faces.bean.*;
/**This is the product creation class for the user form.*/
@ManagedBean 
@ViewScoped
public class ProductUser {
	
	int id;
	String title;
	String genre;
	String leadAct;
	String studio;
	String director;
	int length;
	int year;
	double price;
	String vidImg;
	
	/**Constructors */
	public ProductUser() {
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
	
	public ProductUser(int id,String title, String genre, String leadAct, String studio, String director,
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
