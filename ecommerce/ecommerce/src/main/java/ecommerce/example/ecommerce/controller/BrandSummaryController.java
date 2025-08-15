package ecommerce.example.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ecommerce.example.ecommerce.model.BrandSummaryModel;
import ecommerce.example.ecommerce.repo.BrandSummaryRepository;

@RestController
@RequestMapping("ecommerce/brandfilters")
@CrossOrigin(origins = "*")
public class BrandSummaryController {
	
	@Autowired
	private BrandSummaryRepository brandSummaryRepository;

	
	@GetMapping("/all")
    public List<BrandSummaryModel> getAllFilters() {
        return brandSummaryRepository.findAll();
    }

	
	@GetMapping("/filterByPrice/{price}")
    public List<BrandSummaryModel> getProductsByPrice(@PathVariable int price) {
        return brandSummaryRepository.findByPrice(price);
    }
}
