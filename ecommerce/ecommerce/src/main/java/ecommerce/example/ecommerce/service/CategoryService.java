package ecommerce.example.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.example.ecommerce.model.CategoryModel;
import ecommerce.example.ecommerce.repo.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired CategoryRepository categoryRepo;
	
	public CategoryModel saveCategory(CategoryModel category) {
        return categoryRepo.save(category);
    }
	
	

}
