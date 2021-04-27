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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","haveColor"})
public class Color {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String colorId;
	private String colorCode;

	@OneToMany(cascade=CascadeType.ALL, mappedBy = "colorId")
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

	public List<HaveColor> getHaveColor() {
		return haveColor;
	}

	public void setHaveColor(List<HaveColor> haveColor) {
		this.haveColor = haveColor;
	}

}
