package ecommerce.example.ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ecommerce.example.ecommerce.model.MailModel;

public interface MailRepo extends JpaRepository<MailModel, Long> {
}
