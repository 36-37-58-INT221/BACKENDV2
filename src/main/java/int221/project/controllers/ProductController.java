package int221.project.controllers;
//package int221.practice.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import org.springframework.web.bind.annotation.RequestParam;
//
//import int221.practice.models.Product;
//import int221.practice.repositories.ProductRepository;
//
//import java.util.List;
//
//@Controller
//public class ProductController {
//	@Autowired
//	private ProductRepository productRepository;
//
//	@RequestMapping("/product")
//	public String product(Model model) {
//		model.addAttribute("products", productRepository.findAll());
//		return "product";
//	}
//
//	@RequestMapping("/productWithPage")
//	public String productWithPage(
//			@RequestParam(defaultValue = "0") Integer pageNo,
//			@RequestParam(defaultValue = "5") Integer pageSize,
//			@RequestParam(defaultValue = "prodPrice") String sortBy,
//			Model model) {
//		Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy) );
//		Page<Product> pageResult = productRepository.findAll(pageable);
//		model.addAttribute("products", pageResult.getContent());
//		return "product";
//	}
//
//	@RequestMapping("/show/{id}")
//	public String show(@PathVariable Long id, Model model) {
//		model.addAttribute("product", productRepository.findById(id).orElse(null));
//		return "show";
//	}
//
//	@RequestMapping("/create")
//	public String create(Model model) {
//		return "create";
//	}
//
//	@RequestMapping("/save")
//	public String save(Product product, Model model) {
//		productRepository.save(product);
//		model.addAttribute("product", product);
//		return "redirect:/show/" + product.getId();
//	}
//
//	@RequestMapping("/delete")
//	public String delete(@RequestParam Long id, Model model) {
//		productRepository.deleteById(id);
//		return "redirect:/product";
//	}
//	@RequestMapping("/edit/{id}")
//	public String edit(@PathVariable Long id, Model model) {
//		model.addAttribute("product", productRepository.findById(id).orElse(null));
//		return "edit";
//	}
//
//	@RequestMapping("/update")
//	public String update(@RequestParam Long id, @RequestParam String prodName, @RequestParam String prodDesc, @RequestParam Double prodPrice, @RequestParam String prodImage) {
//		Product product = productRepository.findById(id).orElse(null);
//		product.setProdName(prodName);
//		product.setProdDesc(prodDesc);
//		product.setProdImage(prodImage);
//		product.setProdPrice(prodPrice);
//		productRepository.save(product);
//
//		return "redirect:/show/" + product.getId();
//	}
//	@RequestMapping("/price")
//	public String findByPrice(@RequestParam(defaultValue = "0") Double lower, @RequestParam(defaultValue = "100000") Double upper, Model model) {
//		List<Product> products = productRepository.findByProdPriceBetween(lower,upper);
//		model.addAttribute("products", products);
//		return "product";
//	}
//}
//
