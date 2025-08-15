package ecommerce.example.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ecommerce.example.ecommerce.model.CategoryModel;
import ecommerce.example.ecommerce.service.WishlistService;

@RestController
@RequestMapping("/wishlist/v7")
@CrossOrigin
public class WishlistController {

    @Autowired
    private WishlistService wishlistService;

    // Get all wishlist items
    @GetMapping("/all")
    public List<CategoryModel> getAllWishlistItems() {
        return wishlistService.getAllWishlistItems();
    }

    // Add item to wishlist
    @PostMapping("/add")
    public ResponseEntity<CategoryModel> addToWishlist(@RequestBody CategoryModel category) {
        CategoryModel saved = wishlistService.saveToWishlist(category);
        return ResponseEntity.ok(saved);
    }

    // Delete item from wishlist
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> removeFromWishlist(@PathVariable int id) {
        wishlistService.deleteFromWishlist(id);
        return ResponseEntity.ok("Removed from wishlist.");
    }
}
