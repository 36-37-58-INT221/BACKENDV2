package int221.project.models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
//import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class HaveColor {

	@EmbeddedId
	HaveColor id;
	@ManyToOne
    @MapsId("productId")
//    @JoinColumn(name = "student_id")
    Product product;

    @ManyToOne
    @MapsId("colorId")
//    @JoinColumn(name = "course_id")
    Color color;

    String imageSrc;
	
	
	
	public HaveColor() {
		
		}

	

	public HaveColor getId() {
		return id;
	}



	public void setId(HaveColor id) {
		this.id = id;
	}



	public Product getStudent() {
		return product;
	}



	public void setStudent(Product product) {
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