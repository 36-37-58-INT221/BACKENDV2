//package int221.project.controllers;
//
//import java.text.SimpleDateFormat;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import int221.project.exceptions.AllException;
//import int221.project.models.Product;
//import int221.project.exceptions.ExceptionResponse;
//
//@RestController
//@RequestMapping("/test")
//public class testRestController {
//
//	private java.sql.Date myObj = new java.sql.Date(0);
//
//	private static final Map<String, Product> test = new HashMap<>();
//	{
//		test.put("1001", new Product("1001", "ipone", 1200, "good", myObj, "path1", "brandfk1"));
//		test.put("1002", new Product("1002", "sumsung", 2555, "bad", myObj, "path2", "brandfk2"));
//		test.put("1003", new Product("1003", "nani", 3441, "soso", myObj, "path3", "brandfk3"));
//		test.put("1004", new Product("1004", "wtf", 4888, "bruhh", myObj, "path4", "brandfk4"));
//		test.put("1005", new Product("1005", "idk", 5200, "GG", myObj, "path5", "brandfk5"));
//
//	}
//
//	@GetMapping("")
//	public List<Product> surveyList() {
//		return new ArrayList<>(test.values());
//	}
//
//	@GetMapping("/{productId}")
//	public Product testProduct(@PathVariable String productId) {
//		if (test.get(productId) == null) {
//			throw new AllException(ExceptionResponse.ERROR_CODE.DOES_NOT_FIND_ID,
//					"id: {" + productId + "} DOES_NOT_FIND_ID");
//		}
//		return test.get(productId);
//	}
//
//	@PostMapping("")
//	public Product create(@RequestBody Product newSurvey) {
//		if (test.get(newSurvey.getProductId()) != null) {
//			throw new AllException(ExceptionResponse.ERROR_CODE.PRODUCT_ALREADY_EXIST,
//					"id: {" + newSurvey.getProductId() + "} already exist !!");
//		}
//		test.put(newSurvey.getProductId(), newSurvey);
//		return newSurvey;
//	}
//
//	@PutMapping("")
//	public Product update(@RequestBody Product newSurvey) {
//		test.put(newSurvey.getProductId(), newSurvey);
//		return newSurvey;
//	}
//
//	@DeleteMapping("/{productId}")
//	public Product delete(@PathVariable String productId) {
//		return test.remove(productId);
//	}
//
//}
