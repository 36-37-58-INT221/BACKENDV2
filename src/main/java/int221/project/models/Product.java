package int221.project.models;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	private String imageName;
	private String name;
	private String description;

	@ManyToMany
	@JoinTable(name = "HaveColor", joinColumns = @JoinColumn(name = "productId"), inverseJoinColumns = @JoinColumn(name = "colorId"))
	private List<Color> color;

	private double price;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "brandid", nullable = false)
	private Brand brand;

	private Date manufactureDate;

	public Product() {
	}

	public Product(int productId, String imageName, String name, String description, List<Color> color, double price,
			Brand brand, Date manufactureDate) {
		super();
		this.productId = productId;
		this.imageName = imageName;
		this.name = name;
		this.description = description;
		this.color = color;
		this.price = price;
		this.brand = brand;
		this.manufactureDate = manufactureDate;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Color> getColor() {
		return color;
	}

	public void setColor(List<Color> color) {
		this.color = color;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Date getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
}