package int221.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import groovyjarjarpicocli.CommandLine.Model;
import int221.project.models.Product;
import int221.project.repositories.ProductsJpaRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductsRestController {
	@Autowired
	ProductsJpaRepository productsJpaRepository;
//	ColorJpaRepository colorJpaRepository;
//	BrandJpaRepository brandJpaRepository;
//	ExtendService ES;

//	@GetMapping("/products/{code}")
//	public Product show(@PathVariable String code) {
//
//		return productsJpaRepository.findById(code).orElse(null);
//	}
//
//	@GetMapping("/products")
//	public List<Product> allProducts() {
//		return productsJpaRepository.findAll();
//	}

//	@RequestMapping // รับrequestทุกชนิด
//	public String request() {
//		
//		return;
//	};
//--------------------------------------------------------------------
//	@GetMapping("/color/{colorId}") // รับแบบget
//	public Color getColor(@PathVariable String colorId) {
//		return colorJpaRepository.findById(colorId).orElse(null);
//	};
//
//	@GetMapping("/brand/{brandId}") // รับแบบget
//	public Brand getBrand(@PathVariable String brandId) {
//		return brandJpaRepository.findById(brandId).orElse(null);
//	};
	
	@GetMapping("/products}") // รับแบบget
	public List<Product> getAllProduct() {
		return productsJpaRepository.findAll();
	};

//	@PostMapping("/form") // รับแบบPost
//	public String post(Product product) {
//		productsJpaRepository.save(product);
//		if(productsJpaRepository.existsById(product.getProductId())){
//			throw new AllException(ExceptionResponse.ERROR_CODE.PRODUCT_ALREADY_EXIST, "id: {" + product.getProductId() + "} already exist !!");
//		}
//		return product.getProductId();
//	};
//
//	@PutMapping("/products/put/{id}") // รับแบบPut
//	public Product put(@RequestParam Product product,@PathVariable String id ) {
//		if(productsJpaRepository.findById(id) ==null) {
//			throw new AllException(ExceptionResponse.ERROR_CODE.PRODUCT_ALREADY_EXIST, "id: {" + product.getProductId() + "} already exist !!");
//		}
//		ES.updateProduct(id, product);
//		return product;
//	};
//
//	@DeleteMapping("/products/delete/{id}") // รับแบบDelete
//	public void delete(@PathVariable String id) {
//		if(productsJpaRepository.findById(id) == null) {
//			throw new AllException(ExceptionResponse.ERROR_CODE.DOES_NOT_FIND_ID, "Does not fine Id!!");
//		}
//		for (int i = 0; i < productsJpaRepository.findAll().size(); i++) {
//			if (productsJpaRepository.findById(id).equals(id)) {
//				productsJpaRepository.deleteById(id);
//				break;
//			}
//		}
//	};
//    @PostMapping("/uploadImage")
//    public String uploadImage(@RequestParam("imageFile") MultipartFile imageFile) {
//    	String returnValue = "start";
//    	try {
//    		ES.saveImage(imageFile);
//    	}catch (Exception e) {
//    		e.printStackTrace();
//			returnValue = "error";
//		}
//    	return returnValue;
//    }
}
