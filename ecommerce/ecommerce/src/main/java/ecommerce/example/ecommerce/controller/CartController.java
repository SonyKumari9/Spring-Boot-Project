package ecommerce.example.ecommerce.controller;

import ecommerce.example.ecommerce.model.CartItemModel;
import ecommerce.example.ecommerce.model.HomeModel;
import ecommerce.example.ecommerce.repo.CartItemRepository;
import ecommerce.example.ecommerce.repo.HomeRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "*")
public class CartController {

    @Autowired
    private CartItemRepository cartRepo;

    @Autowired
    private HomeRepo homeRepo;

    // ✅ Add to Cart
    @PostMapping("/add/{productId}")
    public CartItemModel addToCart(@PathVariable Long productId,
                                   @RequestParam String sessionId,
                                   @RequestParam int quantity,
                                   @RequestParam(required = false) String size,
                                   @RequestParam(required = false) String color) {

        HomeModel product = homeRepo.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + productId));

        CartItemModel item = new CartItemModel();
        item.setProductId(productId);
        item.setProductName(product.getName());
        item.setImageUrl(product.getImageUrl());
        item.setQuantity(quantity);
        item.setPrice(product.getPrice());
        item.setSessionId(sessionId);
        item.setSize(size);
        item.setColor(color);

        return cartRepo.save(item);
    }

    // ✅ Get Cart Items
    @GetMapping("/{sessionId}")
    public List<CartItemModel> getCartItems(@PathVariable String sessionId) {
        return cartRepo.findBySessionId(sessionId);
    }

    // ✅ Remove Item
    @DeleteMapping("/remove/{id}")
    public void removeFromCart(@PathVariable Long id) {
        cartRepo.deleteById(id);
    }

    // ✅ Clear Cart
    @DeleteMapping("/clear/{sessionId}")
    public void clearCart(@PathVariable String sessionId) {
        cartRepo.deleteBySessionId(sessionId);
    }
}
