package business;
import java.util.List;

import javax.ejb.*;
import beans.*;

@Local
public interface ProductsBusinessInterface {
	/**Methods needed for the Products Business Service*/
	public List<Product> getProducts();
	public void setProducts(List<Product> products);
	public List<Product> deleteProducts();


}
