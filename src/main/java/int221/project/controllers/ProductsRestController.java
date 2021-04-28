package int221.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import groovyjarjarpicocli.CommandLine.Model;
import int221.project.exceptions.AllException;
import int221.project.exceptions.ExceptionResponse;
import int221.project.models.Brand;
import int221.project.models.Color;
import int221.project.models.ExtendService;
import int221.project.models.Product;
import int221.project.repositories.BrandJpaRepository;
import int221.project.repositories.ColorJpaRepository;
import int221.project.repositories.ProductsJpaRepository;

import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = { "http://localhost:8080"})
@RestController
public class ProductsRestController {
	@Autowired
	ProductsJpaRepository productsJpaRepository;
	@Autowired
	ColorJpaRepository colorJpaRepository;
	@Autowired
	BrandJpaRepository brandJpaRepository;
	@Autowired
	ExtendService ES;

//	@RequestMapping // รับrequestทุกชนิด
//	public String request() {
//		
//		return;
//	};
//--------------------------------------------------------------------

	@GetMapping("/color/{colorId}") // รับแบบget
	public Color getColor(@PathVariable int colorId) {
		return colorJpaRepository.findById(colorId).orElse(null);
	};

	@GetMapping("/brand/{brandId}") // รับแบบget
	public Brand getBrand(@PathVariable int brandId) {
		return brandJpaRepository.findById(brandId).orElse(null);
	};

	@GetMapping("/products") // รับแบบget success
	public List<Product> getAllProduct() {
		return productsJpaRepository.findAll();
	};

	@GetMapping("/products/{id}") // success
	public Product show(@PathVariable int id) {
		if (productsJpaRepository.findById(id).isEmpty()) {
			throw new AllException(ExceptionResponse.ERROR_CODE.DOES_NOT_FIND_ID,
					"id: {" + id + "} Does not fine Id!!");
		}
		return productsJpaRepository.findById(id).orElse(null);
	};

	@PostMapping("/form") // รับแบบPost
	public Product post(@RequestBody Product product) {
		if (productsJpaRepository.existsById(product.getProductId())) {
			throw new AllException(ExceptionResponse.ERROR_CODE.PRODUCT_ALREADY_EXIST,
					"id: {" + product.getProductId() + "} already exist !!");
		}
		productsJpaRepository.save(product);
		return product;
	};

	@PutMapping("/products/put/{id}") // รับแบบPut
	public Product put(@RequestParam Product product, @PathVariable int id) {
		if (productsJpaRepository.findById(id).isEmpty()) {
			throw new AllException(ExceptionResponse.ERROR_CODE.PRODUCT_ALREADY_EXIST,
					"id: {" + product.getProductId() + "} already exist !!");
		}
		ES.updateProduct(id, product);
		return product;
	};

	@DeleteMapping("/products/delete/{id}") // รับแบบDelete
	public void delete(@PathVariable int id) {
		if (productsJpaRepository.findById(id).isEmpty()) {
			throw new AllException(ExceptionResponse.ERROR_CODE.DOES_NOT_FIND_ID, "Does not fine Id!!");
		}
		for (int i = 0; i < productsJpaRepository.findAll().size(); i++) {
			if (productsJpaRepository.findById(id).equals(id)) {
				productsJpaRepository.deleteById(id);
				break;
			}
		}
	};

	@PostMapping("/uploadImage")
	public String uploadImage(@RequestParam("imageFile") MultipartFile imageFile) {
		String returnValue = "start";
		try {
			ES.saveImage(imageFile);
		} catch (Exception e) {
			e.printStackTrace();
			returnValue = "error";
		}
		return returnValue;
	}
}
