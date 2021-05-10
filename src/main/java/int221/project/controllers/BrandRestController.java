package int221.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import int221.project.models.Brand;
import int221.project.repositories.BrandJpaRepository;

@CrossOrigin(origins = "http://52.187.120.198:8080")
@RestController
public class BrandRestController {
	@Autowired
	BrandJpaRepository brandJpaRepository;

	@GetMapping("/brands")
	public List<Brand> getAllBrand() {
		return brandJpaRepository.findAll();
	};

	@GetMapping("/brand/{brandId}")
	public Brand getBrand(@PathVariable int brandId) {
		return brandJpaRepository.findById(brandId).orElse(null);
	};

}
