package int221.project.models;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JoinColumn(name = "brandId", referencedColumnName = "brandId")

	private String productId;
	private String name;
	private String description;
	private int price;
	private Date manufactureDate;
	private String picPath;
//	@ManyToOne(fetch = FetchType.LAZY, optional = false)
//	@JoinColumn(name = "post_id", nullable = false)
//	@OnDelete(action = OnDeleteAction.CASCADE)
//	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "brandid", nullable = false)
	private Brand brandId;


	public Product() {
	};

	public Product(String productId, String name, String description, int price, Date manufactureDate, String picPath,
			Brand brandId) {
		this.productId = productId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.manufactureDate = manufactureDate;
		this.picPath = picPath;
		this.brandId = brandId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	public String getPicPath() {
		return picPath;
	}

	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}

	public Brand getBrand() {
		return brandId;
	}

	public void setBrand(Brand brand) {
		this.brandId = brand;
	}

}