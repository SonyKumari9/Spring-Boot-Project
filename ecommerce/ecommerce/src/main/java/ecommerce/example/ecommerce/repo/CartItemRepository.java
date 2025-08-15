package ecommerce.example.ecommerce.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ecommerce.example.ecommerce.model.CartItemModel;

public interface CartItemRepository extends JpaRepository<CartItemModel, Long> {
    List<CartItemModel> findBySessionId(String sessionId);
    void deleteBySessionId(String sessionId);
}
