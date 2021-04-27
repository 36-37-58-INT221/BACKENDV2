package int221.project.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Brand {
	@Id
	private String brandId;
	private String name;
	@OneToMany(mappedBy = "brand")//เป็น bidirectional mapping ที่ map กลับไปยัง table product
	private List<Product> products;

	public Brand() {
	};

	public Brand(String brandId, String name) {
		this.brandId = brandId;
		this.name = name;
	}

	public String getBrandId() {
		return brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	

}
