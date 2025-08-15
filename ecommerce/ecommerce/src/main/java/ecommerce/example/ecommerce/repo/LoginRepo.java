package ecommerce.example.ecommerce.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ecommerce.example.ecommerce.model.LoginModel;


@Repository
public interface LoginRepo extends JpaRepository<LoginModel, Integer> {

	LoginModel findByMobileAndPassword(String mobile, String password);
	
	Optional<LoginModel> findByEmail(String email);




}
