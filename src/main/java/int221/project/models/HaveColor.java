package int221.project.models;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class HaveColor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;

	@ManyToOne
	@JoinColumn(name = "productId", nullable = false)
	private Product product;

	@ManyToOne
	@JoinColumn(name = "colorId", nullable = false)
	private Color color;

	private String imageSrc;

	public HaveColor() {
	}

	public HaveColor(String id, Product product, Color color) {
		this.id = id;
		this.product = product;
		this.color = color;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getImageSrc() {
		return imageSrc;
	}

	public void setImageSrc(String imageSrc) {
		this.imageSrc = imageSrc;
	}

	

}