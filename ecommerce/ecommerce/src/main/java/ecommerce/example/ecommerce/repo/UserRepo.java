package ecommerce.example.ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ecommerce.example.ecommerce.model.UserModel;

@Repository
public interface UserRepo extends JpaRepository<UserModel, Integer> {
    UserModel findByUserPhone(String mobile);
}
