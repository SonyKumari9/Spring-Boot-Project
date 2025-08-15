package ecommerce.example.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.example.ecommerce.model.LoginModel;
import ecommerce.example.ecommerce.repo.LoginRepo;

@Service
public class LoginService {
	
	@Autowired
	private LoginRepo loginrepo;

	public LoginModel loginEcommerce(LoginModel loginmdl) {
		return loginrepo.save(loginmdl);
	}

	public List<LoginModel> getAll() {
		return loginrepo.findAll();
	}

	public LoginModel getDataByMobileAndPassword(String mobile, String password) {
	    return loginrepo.findByMobileAndPassword(mobile, password);
	        
	}

	public LoginModel save(LoginModel user) {
	    return loginrepo.save(user);
	}

	public Optional<LoginModel> findByEmail(String email) {
        return loginrepo.findByEmail(email); 
    }



	
	

	


}
