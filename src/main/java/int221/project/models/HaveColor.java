package int221.project.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler","product"})
@Entity
public class HaveColor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int haveColorId;

	@ManyToOne( fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "productId", nullable = false)
	private Product product;

	@ManyToOne( fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "colorId", nullable = false)
	private Color color;

//	private String imageSrc;

	public HaveColor() {
	}

	public HaveColor(int haveColorId, Product product, Color color) {
		this.haveColorId = haveColorId;
		this.product = product;
		this.color = color;
	}

	public int getHaveColorId() {
		return haveColorId;
	}

	public void setHaveColorId(int haveColorId) {
		this.haveColorId = haveColorId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
//	public String getImageSrc() {
//		return imageSrc;
//	}
//
//	public void setImageSrc(String imageSrc) {
//		this.imageSrc = imageSrc;
//	}

}