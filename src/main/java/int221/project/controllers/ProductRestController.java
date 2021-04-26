//package int221.project.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import int221.practice.models.ExtendService;
//import int221.practice.models.Product;
//import int221.practice.repositories.ProductRepository;
//
//import java.util.List;
//
//@RestController
//public class ProductRestController {
//    @Autowired
//    private ProductRepository productRepository;
//    @Autowired
//    private ExtendService ES;
//    @GetMapping("/api/show/{id}")
//    public Product show(@PathVariable Long id) {
//       return productRepository.findById(id).orElse(null);
//    }
//    @GetMapping("/api/product")
//    public List<Product> product() {
//        return productRepository.findAll();
//    }
//
//    @GetMapping("/api/productWithPage")
//    public List<Product> productWithPage(
//            @RequestParam(defaultValue = "0") Integer pageNo,
//            @RequestParam(defaultValue = "5") Integer pageSize,
//            @RequestParam(defaultValue = "prodPrice") String sortBy,
//            Model model) {
//        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy) );
//        Page<Product> pageResult = productRepository.findAll(pageable);
//        return pageResult.getContent();
//    }
//    @PostMapping("/api/uploadImage")
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
//}
