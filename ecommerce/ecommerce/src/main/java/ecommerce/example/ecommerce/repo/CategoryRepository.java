package ecommerce.example.ecommerce.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ecommerce.example.ecommerce.model.CategoryModel;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryModel, Integer>{
	
	List<CategoryModel> findTop5ByOrderByCategoryIdDesc();


}
