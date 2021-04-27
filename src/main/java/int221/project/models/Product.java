package int221.project.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product {

	@Id
	@JoinColumn(name = "brandfk", referencedColumnName = "brandId")
	@JoinColumn(name = "haveId", referencedColumnName = "haveId")

	private String productId;
	private String name;
	private int price;
	private String description;
	private Date manufactureDate;
	private String picPath;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
//	@JoinColumn(name = "post_id", nullable = false)
//	@OnDelete(action = OnDeleteAction.CASCADE)
//	@JsonIgnore
	private Brand brand;
	private HaveColor haveColor;

	public Product() {
	};

	public Product(String productId, String name, int price, String description, Date manufactureDate, String picPath,
			Brand brand, HaveColor haveId) {
		super();
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.description = description;
		this.manufactureDate = manufactureDate;
		this.picPath = picPath;
		this.brand = brand;
		this.haveColor = haveId;
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
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public HaveColor getHaveColor() {
		return haveColor;
	}

	public void setHaveColor(HaveColor haveColor) {
		this.haveColor = haveColor;
	}

	

}