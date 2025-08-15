package ecommerce.example.ecommerce.controller;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ecommerce.example.ecommerce.model.CategoryModel;
import ecommerce.example.ecommerce.service.CategoryService;

@RestController
@RequestMapping("/categories/v6")
@CrossOrigin
public class CategoryController {
	
	@Autowired CategoryService categoryService;
	
	
	// List images from folder to getting
	@GetMapping("/images/{folder}")
	public List<String> getImagesByFolder(@PathVariable String folder) {
	    File targetFolder = new File("D:/sts project/ecommerce/images/" + folder);
	    if (!targetFolder.exists() || !targetFolder.isDirectory()) {
	        return List.of();
	    }

	    return Arrays.stream(targetFolder.listFiles((dir, name) -> name.toLowerCase().endsWith(".jpg")))
	                 .map(file -> "http://localhost:8086/images/" + folder + "/" + file.getName())
	                 .collect(Collectors.toList());
	}



	
	
    // Save selected image to category 
	@PostMapping("/saveitm")
	public ResponseEntity<CategoryModel> saveCategory(@RequestBody CategoryModel category) {
	    CategoryModel savedCategory = categoryService.saveCategory(category);
	    return new ResponseEntity<>(savedCategory, HttpStatus.OK);
	}



}
