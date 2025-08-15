package ecommerce.example.ecommerce.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ecommerce.example.ecommerce.model.OrderModel;

@Repository
public interface OrderRepo extends JpaRepository<OrderModel, Integer> {

	List<OrderModel> findByMobile(String mobile);


}
