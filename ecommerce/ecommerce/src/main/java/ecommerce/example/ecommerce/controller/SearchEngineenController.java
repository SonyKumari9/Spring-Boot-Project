package ecommerce.example.ecommerce.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ecommerce.example.ecommerce.model.HomeModel;
import ecommerce.example.ecommerce.repo.HomeRepo;
import ecommerce.example.ecommerce.service.HomeService;

@RestController
@RequestMapping("/ecommerce/search")
@CrossOrigin
public class SearchEngineenController {

    @Autowired
    private HomeRepo homeRepo;

    @Autowired
    private HomeService externalApiService;

    @GetMapping
    public ResponseEntity<List<HomeModel>> searchProducts(
            @RequestParam(required = false) String query,
            @RequestParam(required = false) String category) {

        List<HomeModel> results = new ArrayList<>();

        //  Search by category only 
        if (category != null && (query == null || query.trim().isEmpty())) {
            results = homeRepo.findByCategoryContainingIgnoreCase(category);
            return ResponseEntity.ok(results);
        }

        //  Search by query only
        if (query != null && (category == null || category.trim().isEmpty())) {
            List<HomeModel> localResults = homeRepo.findByNameContainingIgnoreCase(query);
            List<HomeModel> externalResults = externalApiService.searchByName(query);
            results.addAll(localResults);
            results.addAll(externalResults);
            return ResponseEntity.ok(results);
        }

        // Search by both query and category 
        if (query != null && category != null) {
            List<HomeModel> localResults = homeRepo.findByNameContainingIgnoreCaseAndCategoryIgnoreCase(query, category);
            List<HomeModel> externalResults = externalApiService.searchByNameAndCategory(query, category);
            results.addAll(localResults);
            results.addAll(externalResults);
            return ResponseEntity.ok(results);
        }

        // Return all products if no filters
        results = homeRepo.findAll();
        return ResponseEntity.ok(results);
    }
}
