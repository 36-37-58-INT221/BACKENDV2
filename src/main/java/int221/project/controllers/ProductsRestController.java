package int221.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
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

import java.io.IOException;
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

	@GetMapping("/color/{colorId}") // รับแบบget
	public Color getColor(@PathVariable int colorId) {
		return colorJpaRepository.findById(colorId).orElse(null);
	};

	@GetMapping("/brand/{brandId}") // รับแบบget
	public Brand getBrand(@PathVariable int brandId) {
		return brandJpaRepository.findById(brandId).orElse(null);
	};
	
	@GetMapping("/colors") // รับแบบget success
	public List<Color> getAllColor() {
		return colorJpaRepository.findAll();
	};
	
	@GetMapping("/brands") // รับแบบget success
	public List<Brand> getAllBrand() {
		return brandJpaRepository.findAll();
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

	@PostMapping("/products/add") // รับแบบPost success ใช้อันนี้ก็saveได้นะ
	public Product post(@RequestParam ("imageFile") MultipartFile imageFile,@RequestPart Product product) {
		if (productsJpaRepository.existsById(product.getProductId())) {
			throw new AllException(ExceptionResponse.ERROR_CODE.PRODUCT_ALREADY_EXIST,
					"id: {" + product.getProductId() + "} already exist !!");
		}
		product.setPathPic(product.getName()+imageFile.getOriginalFilename());
		productsJpaRepository.save(product);
		try {
			ES.saveImage(imageFile,product.getPathPic());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	};

	@DeleteMapping("/products/{id}") // รับแบบDelete success
	public String delete(@PathVariable int id) {
		Product product = productsJpaRepository.findById(id).get();
		if (product == null) {
			throw new AllException(ExceptionResponse.ERROR_CODE.DOES_NOT_FIND_ID,
					"id: {" + id + "} Does not fine Id!!");
		}
		productsJpaRepository.deleteById(id);
		try {
			ES.deleteImage(product.getPathPic());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("delete error");
		}

		return "redirect:/products";
	};

	@PutMapping("/products/put/{id}") // รับแบบPut success
	public Product put(@RequestPart Product product, @PathVariable int id,@RequestParam ("imageFile") MultipartFile imageFile) {
		if (productsJpaRepository.findById(id).isEmpty()) {
			throw new AllException(ExceptionResponse.ERROR_CODE.DOES_NOT_FIND_ID,
					"id: {" + id + "} Does not fine Id!!");
		}
		
		Optional<Product> optional = productsJpaRepository.findById(id);
		if (optional.isPresent()) {
			Product existedProduct = optional.get();
			Product existedProduct2 = optional.get();
			existedProduct.setName(product.getName());
			existedProduct.setDescription(product.getDescription());
			existedProduct.setPrice(product.getPrice());
			existedProduct.setManufactureDate(product.getManufactureDate());
//			existedProduct.setPathPic(product.getPathPic());
			existedProduct.setBrand(product.getBrand());
			existedProduct.setColor(product.getColor());
			if(imageFile != null) {
				try {
					ES.deleteImage(existedProduct2.getPathPic());
					existedProduct.setPathPic(product.getName()+imageFile.getOriginalFilename());
					ES.saveImage(imageFile,existedProduct.getPathPic());
				} catch (Exception e) {
					e.printStackTrace();
					 System.out.println( "put error" );
				}
			}
			product.setPathPic(null);
			return productsJpaRepository.save(existedProduct);
		}
		return null;
	};

	@PostMapping("/uploadImage")
	public String uploadImage(@RequestParam("imageFile") MultipartFile imageFile) {
		String returnValue = "start";
		try {
			ES.saveImage(imageFile,"test2.jpg");
		} catch (Exception e) {
			e.printStackTrace();
			returnValue = "error";
		}
		return returnValue;
	}

	@GetMapping(value = "/getImage", produces = { MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE })
	public byte[] getImage(@RequestBody String name) throws IOException {
		return ES.getFile(name);
	}

//	@DeleteMapping("deleteImage")
//	public String deleteImage(@RequestParam String name) {
//		String returnValue = "delete ok";
//		try {
//			ES.deleteImage(name);
//		} catch (Exception e) {
//			e.printStackTrace();
//			returnValue = "delete error";
//		}
//		return returnValue;
//	}

}
