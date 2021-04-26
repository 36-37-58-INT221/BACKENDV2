package int221.project.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Brand {
	@Id
	private String brandId;
	private String name;

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

	
}
