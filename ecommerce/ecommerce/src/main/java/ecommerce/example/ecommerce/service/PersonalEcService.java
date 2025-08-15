package ecommerce.example.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.example.ecommerce.model.PersonalEcModel;
import ecommerce.example.ecommerce.repo.PersonalEcRepo;

@Service
public class PersonalEcService {
	
	
	@Autowired PersonalEcRepo personlrepo;

	public PersonalEcModel CreateserviceMethod(PersonalEcModel personalmodelobj) {
		
		return personlrepo.save(personalmodelobj);
	}
	
	
	public PersonalEcModel getById(Integer id) {
	    return personlrepo.findById(id).orElse(null);
	}

	
	//Updated service
	public PersonalEcModel updateServiceMethod(Integer id, PersonalEcModel updatedModel) {
	    // Check if the record exists
	    PersonalEcModel existingModel = personlrepo.findById(id)
	            .orElseThrow(() -> new RuntimeException("Personal info not found for id: " + id));

	    // Update fields if needs
	    existingModel.setFullName(updatedModel.getFullName());
	    existingModel.setEmail(updatedModel.getEmail());
	    existingModel.setMobile(updatedModel.getMobile());
	    existingModel.setCity(updatedModel.getCity());
	    existingModel.setState(updatedModel.getState());
	    existingModel.setPincode(updatedModel.getPincode());
	    existingModel.setVotercard_no(updatedModel.getVotercard_no());
	    existingModel.setProfile(updatedModel.getProfile());

	    // Save updated model
	    return personlrepo.save(existingModel);
	}
	
	
	//Delete
	
	public void deleteServiceMethod(Integer id) {
	    PersonalEcModel existingModel = personlrepo.findById(id)
	        .orElseThrow(() -> new RuntimeException("Personal info not found for id: " + id));
	    
	    personlrepo.delete(existingModel);
	}

	


}
