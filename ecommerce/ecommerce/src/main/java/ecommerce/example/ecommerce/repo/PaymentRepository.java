package ecommerce.example.ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ecommerce.example.ecommerce.model.PaymentModel;

public interface PaymentRepository extends JpaRepository<PaymentModel, Long> {
}

