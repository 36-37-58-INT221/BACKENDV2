package int221.project.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Color {

	@Id
	private String colorId;
	private String colorCode;
	@OneToMany(mappedBy = "color")
	private List<HaveColor> haveColor;

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
