package ecommerce.example.ecommerce.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ecommerce.example.ecommerce.model.ContactModel;
import ecommerce.example.ecommerce.repo.ContactRepo;

@RestController
@RequestMapping("/project/contactme")
@CrossOrigin("*")
public class ContactController {
	
	@Autowired
	ContactRepo  contactRepo;
	
	@PostMapping("/contact/save")
	public ResponseEntity<Map<String, String>> saveMessage(@RequestBody ContactModel contact) {
	    contactRepo.save(contact);
	    Map<String, String> response = new HashMap<>();
	    response.put("message", "Message saved!");
	    return ResponseEntity.ok(response);
	}


}
