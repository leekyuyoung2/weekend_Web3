package product;
// map 구조로 만듦

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService {
	private Map<String, Product> products = 
			new HashMap<>();
	
	// 생성자... 기본생성자(매개변수가 없기때문에)
	// DB 역활을 하는 메소드
	public ProductService() {
		Product p = new Product("101","애플12","애플",1200000,"2022.03.26");
		products.put("101",p);
		p = new Product("102","갤럭시22","삼성전자",1500000,"2022.03.27");
		products.put("102",p);
		p = new Product("103","엘지폰","엘지전자",900000,"2022.03.25");
		products.put("103",p);
	}
	// 전체 상품 리스트를 조회하는 함수
	public List<Product> findAll(){
		return (List<Product>) products.values();
	}
	
	// 개별 조회가 가능한 함수 조건은.. 아이디에 해당하는 제품
	public Product find(String id) {
		return products.get(id);
	}
	
}
