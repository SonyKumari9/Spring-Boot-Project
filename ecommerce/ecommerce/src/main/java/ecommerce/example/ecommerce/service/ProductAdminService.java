package ecommerce.example.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.example.ecommerce.model.CategoryModel;
import ecommerce.example.ecommerce.model.HomeModel;
import ecommerce.example.ecommerce.model.ProductAdminModel;
import ecommerce.example.ecommerce.repo.CategoryRepository;
import ecommerce.example.ecommerce.repo.HomeRepo;

@Service
public class ProductAdminService {

    @Autowired
    private HomeRepo homeRepo;

    @Autowired
    private CategoryRepository categoryRepo;

    public List<ProductAdminModel> getAllCombinedProducts() {
        List<HomeModel> homeList = homeRepo.findAll();
        List<CategoryModel> categoryList = categoryRepo.findAll();

        List<ProductAdminModel> result = new ArrayList<>();

        // Match based on index (or match by brand if needed)
        int size = Math.min(homeList.size(), categoryList.size());

        for (int i = 0; i < size; i++) {
            result.add(new ProductAdminModel(homeList.get(i), categoryList.get(i)));
        }

        return result;
    }
    
    
    public HomeModel addNewProduct(HomeModel homeProduct) {
        return homeRepo.save(homeProduct);
    }

    
    public void deleteHomeProduct(Long id) {
        homeRepo.deleteById(id);
    }

    public HomeModel updateHomeProduct(Long id, HomeModel updatedProduct) {
        return homeRepo.findById(id).map(existing -> {
            existing.setName(updatedProduct.getName());
            existing.setBrand(updatedProduct.getBrand());
            existing.setPrice(updatedProduct.getPrice());
            existing.setImageUrl(updatedProduct.getImageUrl());
            existing.setQuantity(updatedProduct.getQuantity());
            existing.setDescription(updatedProduct.getDescription());
            existing.setCategory(updatedProduct.getCategory());
            // Add more fields as needed...
            return homeRepo.save(existing);
        }).orElse(null);
        
    }
    
    
}
