package product;
// map ������ ����

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService {
	private Map<String, Product> products = 
			new HashMap<>();
	
	// ������... �⺻������(�Ű������� ���⶧����)
	// DB ��Ȱ�� �ϴ� �޼ҵ�
	public ProductService() {
		Product p = new Product("101","����12","����",1200000,"2022.03.26");
		products.put("101",p);
		p = new Product("102","������22","�Ｚ����",1500000,"2022.03.27");
		products.put("102",p);
		p = new Product("103","������","��������",900000,"2022.03.25");
		products.put("103",p);
	}
	// ��ü ��ǰ ����Ʈ�� ��ȸ�ϴ� �Լ�
	public List<Product> findAll(){
		return (List<Product>) products.values();
	}
	
	// ���� ��ȸ�� ������ �Լ� ������.. ���̵� �ش��ϴ� ��ǰ
	public Product find(String id) {
		return products.get(id);
	}
	
}
