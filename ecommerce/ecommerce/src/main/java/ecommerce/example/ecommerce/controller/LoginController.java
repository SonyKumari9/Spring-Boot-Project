package ecommerce.example.ecommerce.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import ecommerce.example.ecommerce.model.LoginModel;
import ecommerce.example.ecommerce.service.LoginService;

@RestController
@RequestMapping("/ecommerce/v1")
@CrossOrigin
public class LoginController {
	
	
	@Autowired LoginService loginservice;
	
	@PostMapping("/login")
	public ResponseEntity<LoginModel> LoginEcommerce(@RequestBody LoginModel loginmdl)
	{
		LoginModel l =loginservice.loginEcommerce(loginmdl);
		return new ResponseEntity<LoginModel>(l,HttpStatus.OK);
		
	}
	
	
	@GetMapping("/get")
	public ResponseEntity<List<LoginModel>> LoginGetdata()
	{
		List<LoginModel> l = loginservice.getAll();
		return new ResponseEntity<List<LoginModel>>(l,HttpStatus.OK);
	
				
	}
	
	//get data with particular one
	@GetMapping("/{mobile}/{password}")
	public ResponseEntity<LoginModel> loginUser(@PathVariable String mobile, @PathVariable String password) {
	    LoginModel login = loginservice.getDataByMobileAndPassword(mobile, password);
	    return new ResponseEntity<>(login, HttpStatus.OK);
	}
	
	
	//Profile get & updated data & image from login database.
	
	// Get one user by email (GET)
    @GetMapping("/user/{email}")
    public ResponseEntity<LoginModel> getUserByEmail(@PathVariable String email) {
        Optional<LoginModel> userOpt = loginservice.findByEmail(email);
        return userOpt
                .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    
 // Update profile image URL by email (PUT)
    @PutMapping("/update-image/{email}")
    public ResponseEntity<LoginModel> updateUserImage(@PathVariable String email, @RequestParam String imageUrl) {
        Optional<LoginModel> optionalUser = loginservice.findByEmail(email);
        if (optionalUser.isPresent()) {
            LoginModel user = optionalUser.get();
            user.setImageUrl(imageUrl);
            LoginModel updatedUser = loginservice.save(user);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    
    @PutMapping("/update-profile/{email}")
    public ResponseEntity<LoginModel> updateUserProfile(@PathVariable String email, @RequestBody LoginModel updatedData) {
        Optional<LoginModel> optionalUser = loginservice.findByEmail(email);
        if (optionalUser.isPresent()) {
            LoginModel user = optionalUser.get();
            user.setName(updatedData.getName());
            user.setMobile(updatedData.getMobile());
            user.setImageUrl(updatedData.getImageUrl()); // This accepts Base64 string
            LoginModel savedUser = loginservice.save(user);
            return new ResponseEntity<>(savedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    
    
    @PostMapping("/upload-profile-image")
    public ResponseEntity<?> uploadProfileImage(
            @RequestParam("file") MultipartFile file,
            @RequestParam("email") String email) {

        Optional<LoginModel> optionalUser = loginservice.findByEmail(email);
        if (optionalUser.isPresent()) {
            try {
                String folderPath = "D:/sts project/ecommerce/updated_profileimages/";
                LoginModel user = optionalUser.get();

                // Extract extension (.jpg, .png)
                String originalFilename = file.getOriginalFilename();
                String extension = originalFilename.substring(originalFilename.lastIndexOf("."));

                //  Custom filename format: id_image.png
                String uniqueFilename = user.getId() + "_image" + extension;

                File dest = new File(folderPath + uniqueFilename);
                file.transferTo(dest);

                // Save file path in DB 
                user.setImageUrl("/updated_profileimages/" + uniqueFilename);
                loginservice.save(user);

                Map<String, String> response = new HashMap<>();
                response.put("imageUrl", "/updated_profileimages/" + uniqueFilename);
                return new ResponseEntity<>(response, HttpStatus.OK);

            } catch (IOException e) {
                return new ResponseEntity<>("❌ Upload failed: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>("❌ User not found.", HttpStatus.NOT_FOUND);
        }
    }
    
    
    //Password change
    @PutMapping("/change-password")
    public ResponseEntity<?> changePassword(@RequestBody Map<String, String> payload) {
        String email = payload.get("email") != null ? payload.get("email").trim().toLowerCase() : "";
        String currentPassword = payload.get("currentPassword");
        String newPassword = payload.get("newPassword");

        if (email.isEmpty() || currentPassword == null || newPassword == null) {
            return new ResponseEntity<>("Missing input", HttpStatus.BAD_REQUEST);
        }

        Optional<LoginModel> userOpt = loginservice.findByEmail(email);
        if (userOpt.isPresent()) {
            LoginModel user = userOpt.get();
            if (user.getPassword().equals(currentPassword)) {
                user.setPassword(newPassword);
                loginservice.save(user);
                //return new ResponseEntity<>("✅ Password updated successfully", HttpStatus.OK);
                return ResponseEntity.ok(Map.of("message", "✅ Password updated successfully"));

            } else {
                return new ResponseEntity<>("❌ Current password is incorrect", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("❌ User not found", HttpStatus.NOT_FOUND);
        }
    }










	

}
