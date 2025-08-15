package ecommerce.example.ecommerce.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import ecommerce.example.ecommerce.model.OrderManagementModel;


public interface OrderManagementRepo extends JpaRepository<OrderManagementModel, Long> {
}

