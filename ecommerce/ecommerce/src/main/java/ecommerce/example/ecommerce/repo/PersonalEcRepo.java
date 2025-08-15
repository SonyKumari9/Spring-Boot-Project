package ecommerce.example.ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ecommerce.example.ecommerce.model.PersonalEcModel;

@Repository
public interface PersonalEcRepo extends JpaRepository<PersonalEcModel, Integer>{

}
