package int221.project.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "product" })
public class Color {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int colorId;
	private String colorCode;

	@ManyToMany
	private List<Product> product;

	public Color() {
	}

	public Color(int colorId, String colorCode, List<Product> product) {
		super();
		this.colorId = colorId;
		this.colorCode = colorCode;
		this.product = product;
	}

	public int getColorId() {
		return colorId;
	}

	public void setColorId(int colorId) {
		this.colorId = colorId;
	}

	public String getColorCode() {
		return colorCode;
	}

	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

}
