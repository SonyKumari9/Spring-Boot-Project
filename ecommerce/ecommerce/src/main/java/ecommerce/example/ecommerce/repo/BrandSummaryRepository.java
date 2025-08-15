package ecommerce.example.ecommerce.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ecommerce.example.ecommerce.model.BrandSummaryModel;

@Repository
public interface BrandSummaryRepository extends JpaRepository<BrandSummaryModel,Integer>{
	
	 List<BrandSummaryModel> findByPrice(int price);

}
