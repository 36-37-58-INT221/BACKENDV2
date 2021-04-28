package int221.project.models;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler"  })
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int productId;
	private String name;
	private String description;
	private int price;
	private Date manufactureDate;
	private String pathPic;
//	@ManyToOne(fetch = FetchType.LAZY, optional = false)
//	@JoinColumn(name = "post_id", nullable = false)
//	@OnDelete(action = OnDeleteAction.CASCADE)
//	@JsonIgnore
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "brandid", nullable = false)
	private Brand brand;

	@OneToMany(cascade=CascadeType.PERSIST,orphanRemoval =true, mappedBy = "product")
	private List<HaveColor> haveColor;

	public Product() {
	}

	public Product(int productId, String name, String description, int price, Date manufactureDate, String pathPic,
			Brand brand) {
		this.productId = productId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.manufactureDate = manufactureDate;
		this.pathPic = pathPic;
		this.brand = brand;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	public String getPathPic() {
		return pathPic;
	}

	public void setPathPic(String pathPic) {
		this.pathPic = pathPic;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public List<HaveColor> getHaveColor() {
		return haveColor;
	}

	public void setHaveColor(List<HaveColor> haveColor) {
		this.haveColor = haveColor;
	};
	
	
}