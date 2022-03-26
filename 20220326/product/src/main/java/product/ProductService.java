package product;
// map ������ ����

import java.security.Provider.Service;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService {
	private Map<String, Product> products = 
			new HashMap<>();
	
	 
	public ProductService() {
		Product p = new Product("101","112","1",1200000,"2022.03.26");
		products.put("101",p);
		p = new Product("102","122","1",1500000,"2022.03.27");
		products.put("102",p);
		p = new Product("103","1","1",900000,"2022.03.25");
		products.put("103",p);
	}

	public Collection<Product> findAll(){
		return products.values();
	}
	

	public Product find(String id) {
		return products.get(id);
	}
	
}
