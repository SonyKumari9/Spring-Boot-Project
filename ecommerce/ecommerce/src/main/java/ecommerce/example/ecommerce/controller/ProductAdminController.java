package ecommerce.example.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ecommerce.example.ecommerce.model.HomeModel;
import ecommerce.example.ecommerce.model.ProductAdminModel;
import ecommerce.example.ecommerce.service.ProductAdminService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
public class ProductAdminController {

    @Autowired
    private ProductAdminService productAdminService;

    @GetMapping("/products/combined")
    public List<ProductAdminModel> getCombinedProducts() {
        return productAdminService.getAllCombinedProducts();
    }
    
    @PostMapping("/products/add")
    public HomeModel addProduct(@RequestBody HomeModel homeProduct) {
        return productAdminService.addNewProduct(homeProduct);
    }

    
    @DeleteMapping("/products/delete/{id}")
    public String deleteHomeProduct(@PathVariable Long id) {
        productAdminService.deleteHomeProduct(id);
        return "Product with ID " + id + " deleted successfully.";
    }

    
    @PutMapping("/products/update/{id}")
    public HomeModel updateHomeProduct(@PathVariable Long id, @RequestBody HomeModel updatedProduct) {
        return productAdminService.updateHomeProduct(id, updatedProduct);
    }
}
