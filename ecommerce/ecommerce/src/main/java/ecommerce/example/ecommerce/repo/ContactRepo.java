package ecommerce.example.ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ecommerce.example.ecommerce.model.ContactModel;

@Repository
public interface ContactRepo extends JpaRepository<ContactModel, Integer>{

}
