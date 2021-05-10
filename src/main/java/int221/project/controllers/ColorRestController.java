package int221.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import int221.project.models.Color;
import int221.project.repositories.ColorJpaRepository;

@CrossOrigin(origins = "http://52.187.120.198:8080")
@RestController
public class ColorRestController {
	@Autowired
	ColorJpaRepository colorJpaRepository;

	@GetMapping("/colors")
	public List<Color> getAllColor() {
		return colorJpaRepository.findAll();
	};

	@GetMapping("/color/{colorId}")
	public Color getColor(@PathVariable int colorId) {
		return colorJpaRepository.findById(colorId).orElse(null);
	};

}
