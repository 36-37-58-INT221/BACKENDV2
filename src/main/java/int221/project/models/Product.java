package int221.project.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

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
	private String brandfk;
	private String haveId;

	public Product() {
	};

	public Product(String productId, String name, int price, String description, Date manufactureDate, String picPath,
			String brandfk, String haveId) {
		super();
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.description = description;
		this.manufactureDate = manufactureDate;
		this.picPath = picPath;
		this.brandfk = brandfk;
		this.haveId = haveId;
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

	public String getBrandfk() {
		return brandfk;
	}

	public void setBrandfk(String brandfk) {
		this.brandfk = brandfk;
	}

	public String getHaveId() {
		return haveId;
	}

	public void setHaveId(String haveId) {
		this.haveId = haveId;
	}

}