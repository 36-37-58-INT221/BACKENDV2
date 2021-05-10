package int221.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import int221.project.exceptions.AllException;
import int221.project.exceptions.ExceptionResponse;
import int221.project.models.ExtendService;
import int221.project.models.Product;

import int221.project.repositories.ProductsJpaRepository;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://52.187.120.198:8080")
@RestController
public class ProductsRestController {
	@Autowired
	ProductsJpaRepository productsJpaRepository;
	@Autowired
	ExtendService ES;

	@GetMapping("/products")
	public List<Product> getAllProduct() {
		return productsJpaRepository.findAll();
	};

	@GetMapping("/products/{id}")
	public Product show(@PathVariable int id) {
		if (productsJpaRepository.findById(id).isEmpty()) {
			throw new AllException(ExceptionResponse.ERROR_CODE.DOES_NOT_FIND_ID,
					"id: {" + id + "} Does not fine Id!!");
		}
		return productsJpaRepository.findById(id).orElse(null);
	};

	@PostMapping("/products/add")
	public Product post(@RequestParam("imageFile") MultipartFile imageFile, @RequestPart Product product) {
		if (productsJpaRepository.existsById(product.getProductId())) {
			throw new AllException(ExceptionResponse.ERROR_CODE.PRODUCT_ALREADY_EXIST,
					"id: {" + product.getProductId() + "} already exist !!");
		}
		if (productsJpaRepository.findByName(product.getName()) != null) {
			throw new AllException(ExceptionResponse.ERROR_CODE.DUPICATE_IN_PRODUCTS,
					"Name: {" + product.getName() + "} dupicate!!");
		}
		if (imageFile.getContentType().equals("image/png")) {
			product.setImageName(ES.randomString(3)+product.getName() + ".png");
		} else if (imageFile.getContentType().equals("image/jpeg")) {
			product.setImageName(ES.randomString(3)+product.getName() + ".jpg");
		} else {
			throw new AllException(ExceptionResponse.ERROR_CODE.CAN_NOT_UPLOAD_THIS_FILETYPE,
					"can upload png and jpg only");
		}
		productsJpaRepository.save(product);
		try {
			ES.saveImage(imageFile, product.getImageName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	};

	@DeleteMapping("/products/{id}")
	public String delete(@PathVariable int id) {
		Product product = productsJpaRepository.findById(id).get();
		if (product == null) {
			throw new AllException(ExceptionResponse.ERROR_CODE.DOES_NOT_FIND_ID,
					"id: {" + id + "} Does not fine Id!!");
		}
		productsJpaRepository.deleteById(id);
		try {
			ES.deleteImage(product.getImageName());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("delete error");
		}

		return "Delete Success";
	};

	@PutMapping("/products/put/{id}")
	public Product put(@RequestPart Product product, @PathVariable int id,
			@RequestParam(value = "imageFile", required = false) MultipartFile imageFile) {
		if (productsJpaRepository.findById(id).isEmpty()) {
			throw new AllException(ExceptionResponse.ERROR_CODE.DOES_NOT_FIND_ID,
					"id: {" + id + "} Does not fine Id!!");
		}
		if (productsJpaRepository.findByName(product.getName()) != null
				&& productsJpaRepository.findByName(product.getName()).getProductId() != product.getProductId()) {
			throw new AllException(ExceptionResponse.ERROR_CODE.DUPICATE_IN_PRODUCTS,
					"Name: {" + product.getName() + "} dupicate!!");
		}
		Optional<Product> optional = productsJpaRepository.findById(id);
		if (optional.isPresent()) {
			Product existedProduct = optional.get();
			Product existedProduct2 = optional.get();
			existedProduct.setName(product.getName());
			existedProduct.setDescription(product.getDescription());
			existedProduct.setPrice(product.getPrice());
			existedProduct.setManufactureDate(product.getManufactureDate());
			existedProduct.setBrand(product.getBrand());
			existedProduct.setColor(product.getColor());
			if (imageFile != null) {
				try {
					ES.deleteImage(existedProduct2.getImageName());
					if (imageFile.getContentType().equals("image/png")) {
						existedProduct.setImageName(ES.randomString(3)+product.getName() + ".png");
					} else if (imageFile.getContentType().equals("image/jpeg")) {
						existedProduct.setImageName(ES.randomString(3)+product.getName() + ".jpg");
					} else {
						throw new AllException(ExceptionResponse.ERROR_CODE.CAN_NOT_UPLOAD_THIS_FILETYPE,
								"can upload png and jpg only");
					}
					ES.saveImage(imageFile, existedProduct.getImageName());
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("put error");
				}
			}
			return productsJpaRepository.save(existedProduct);
		}
		return null;
	};

	@GetMapping("/products/page")
	public List<Product> productWithPage(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "4") Integer pageSize, @RequestParam(defaultValue = "price") String sortBy) {
		Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		Page<Product> pageResult = productsJpaRepository.findAll(pageable);
		return pageResult.getContent();
	}
}
