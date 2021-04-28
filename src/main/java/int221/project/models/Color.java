package int221.project.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "haveColor" })
public class Color {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int colorId;
	private String colorCode;

	@OneToMany( orphanRemoval = true, mappedBy = "color")
	private List<HaveColor> haveColor;

	public Color() {
	}

	public Color(int colorId, String colorCode, List<HaveColor> haveColor) {
		this.colorId = colorId;
		this.colorCode = colorCode;
		this.haveColor = haveColor;
	}

	public int getColorId() {
		return colorId;
	}

	public void setColorId(int colorId) {
		this.colorId = colorId;
	}

	public String getColorCode() {
		return colorCode;
	}

	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}

	public List<HaveColor> getHaveColor() {
		return haveColor;
	}

	public void setHaveColor(List<HaveColor> haveColor) {
		this.haveColor = haveColor;
	};

}
