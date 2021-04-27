package int221.project.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class HaveColor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@JoinColumn(name = "colorId", referencedColumnName = "colorId")
	@JoinColumn(name = "productId", referencedColumnName = "productId")
	private String haveColorId;
	private String colorId;
	private String productId;

	public HaveColor() {
	};

	public HaveColor(String haveColorId, String colorId, String productId) {
		this.haveColorId = haveColorId;
		this.colorId = colorId;
		this.productId = productId;
	}

	public String getHaveColorId() {
		return haveColorId;
	}

	public void setHaveColorId(String haveColorId) {
		this.haveColorId = haveColorId;
	}

	public String getColorId() {
		return colorId;
	}

	public void setColorId(String colorId) {
		this.colorId = colorId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

}
