package int221.project.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler","product"})
@Entity
public class HaveColor {
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 
	    //@TableGenerator เป็นการระบุว่าให้ database ทำการสร้าง id หรือ primary key ให้เองโดยอัตโนมัติ โดย ให้ squence id นั้นเก็บไว้ที่ table ORPHANDRG_SEQ  ที่มีค่าของ column NAME เท่ากับ USER_FORUM 
//	    @TableGenerator(name = "UserForum_GEN", table = "ORPHANDRG_SEQ", pkColumnName = "NAME", valueColumnName = "VALUE", pkColumnValue = "USER_FORUM")
//	    @GeneratedValue(generator = "UserForum_GEN", strategy = GenerationType.TABLE)
	private int haveColorId;

	@ManyToOne( fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "productId", nullable = false)
	@NotNull
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
	public HaveColor( Color color) {
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