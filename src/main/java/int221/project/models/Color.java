package int221.project.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Color {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String colorId;
	private String colorCode;

	public Color() {
	};

	public Color(String colorId, String colorCode) {
		this.colorId = colorId;
		this.colorCode = colorCode;
	}

	public String getColorId() {
		return colorId;
	}

	public void setColorId(String colorId) {
		this.colorId = colorId;
	}

	public String getColorCode() {
		return colorCode;
	}

	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}

}
