package int221.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import int221.project.models.Product;

public interface ProductsJpaRepository extends JpaRepository<Product, String> {
//	List<Product> findByProductIdAndProductIdNull(String id);
	
}
