package ecommerce.example.ecommerce.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import ecommerce.example.ecommerce.model.PersonalEcModel;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import ecommerce.example.ecommerce.service.PersonalEcService;

@RestController
@RequestMapping("/personaleco/v3")
@CrossOrigin
public class PersonalEcController {
	
	@Autowired PersonalEcService pernlservice;
	
	
	@PostMapping("/personalinfo1")
	public ResponseEntity<PersonalEcModel> CreatePersonalInf(@RequestBody PersonalEcModel personalmodelobj)
	{
		PersonalEcModel prlml= pernlservice.CreateserviceMethod(personalmodelobj);
		return new ResponseEntity<PersonalEcModel>(prlml,HttpStatus.OK);
	}
	
	
	@PostMapping("/personalinfo2")
	public ResponseEntity<String> uploadProfileAndSignature(
	        @RequestParam("id") Integer id,
	        @RequestParam("profile") MultipartFile profile,
	        @RequestParam("signature") MultipartFile signature) {
	    try {
	        String uploadprofileDir = "D:/sts project/ecommerce/profile_image/";
	        String uploasignaturedDir = "D:/sts project/ecommerce/signature_image/";

	        // Save files
	        File profileFile = new File(uploadprofileDir + id+profile.getOriginalFilename());
	        File signatureFile = new File(uploasignaturedDir + id+signature.getOriginalFilename());

	        profile.transferTo(profileFile);
	        signature.transferTo(signatureFile);

	        // Fetch and update existing record
	        PersonalEcModel existing = pernlservice.getById(id);
	        if (existing == null) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User ID not found.");
	        }

	        existing.setProfile(profile.getOriginalFilename());
	        existing.setSignature(signature.getOriginalFilename());
	        //it is used some time    existing.setProfile(profile.getBytes());
	        // it is used some time   existing.setSignature(signature.getBytes());


	        pernlservice.CreateserviceMethod(existing); // save updated

	        return ResponseEntity.ok("Files uploaded and data saved.");
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body("Upload failed: " + e.getMessage());
	    }
	}


	
	//Updated data
	@PutMapping("/personalinfo/{id}")
	public ResponseEntity<PersonalEcModel> updatePersonalInfo(
	        @PathVariable Integer id,
	        @RequestBody PersonalEcModel updatedPersonalModel) {

	    PersonalEcModel updatedModel = pernlservice.updateServiceMethod(id, updatedPersonalModel);

	    return new ResponseEntity<>(updatedModel, HttpStatus.OK);
	}
	
	
	//Delete
	@DeleteMapping("/personalinfo/{id}")
	public ResponseEntity<String> deletePersonalInfo(@PathVariable Integer id) {
		 pernlservice.deleteServiceMethod(id);
	    return new ResponseEntity<>("Personal info with Eccommerce ID " + id + " has been deleted.", HttpStatus.OK);
	}

	
	

}
