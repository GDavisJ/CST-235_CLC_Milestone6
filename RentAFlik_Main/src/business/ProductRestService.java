/** This is the REST Service Class*/

package business;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import javax.ws.rs.*;
import beans.Product;

@RequestScoped
@Path("/products")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })


public class ProductRestService {
	/**Inject the Product Business Interface*/
	@Inject
	private business.ProductsBusinessInterface service;
	
	public ProductRestService(){
		
	}
	
	/**This Method gets the JSON format*/
	@GET
	@Path("/getjson")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getProductsAsJson(){
		return service.getProducts();
	}
	
	
	/**This Method gets the XML format*/
	@GET
	@Path("/getxml")
	@Produces(MediaType.APPLICATION_XML)
	public Product[] getOrdersAsXml() {
		Product[] tmpProduct = new Product[service.getProducts().size()];
		for (int x=0; x<service.getProducts().size(); x++) {
			tmpProduct[x] = service.getProducts().get(x);
		}
		return tmpProduct;
	}
	
	
	/**This method will clear the database*/
	@GET
	@Path("/deletejson")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> deleteProductsAsJson(){
		System.out.println("I'm JSON");
		return service.deleteProducts();
	}
	
}
