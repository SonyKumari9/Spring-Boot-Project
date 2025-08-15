package ecommerce.example.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.example.ecommerce.model.CategoryModel;
import ecommerce.example.ecommerce.repo.CategoryRepository;


@Service
public class WishlistService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryModel> getAllWishlistItems() {
        return categoryRepository.findAll(); // optionally filter only wishlist-marked items
    }

    public CategoryModel saveToWishlist(CategoryModel item) {
        return categoryRepository.save(item);
    }

    public void deleteFromWishlist(int id) {
        categoryRepository.deleteById(id);
    }
}
