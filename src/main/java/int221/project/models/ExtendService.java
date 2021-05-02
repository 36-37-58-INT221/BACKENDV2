package int221.project.models;

import int221.project.repositories.ProductsJpaRepository;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletContext;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ExtendService {
//	private ProductsJpaRepository productRepository;
	String folder = "./public/product-images/";

//	@Autowired
//	public ExtendService(ProductsJpaRepository productsJpaRepository) {
//
//		this.productRepository = productsJpaRepository;
//	}

	public void saveImage(MultipartFile file, String fileName) throws Exception {
		byte[] bytes = file.getBytes();
		Path path = Paths.get(folder, fileName);
		Files.write(path, bytes);
	}

	public byte[] getFile(String file) throws IOException {
		Path path = Paths.get(folder, file);
		return IOUtils.toByteArray(path.toUri());
	}

	public void deleteImage(String fileName) throws Exception {
		Path path = Paths.get(folder, fileName);
		Files.delete(path);
	}

//	public Optional<Product> updateProduct(int id, Product product) {
//		Optional<Product> optionalProduct = productRepository.findById(id);
//		if (optionalProduct.isPresent()) {
//			product.setProductId(id);
//			return Optional.of(productRepository.save(product));
//		} else
//			return optionalProduct;
//	}
}
