package ecommerce.example.ecommerce.repo;

import ecommerce.example.ecommerce.model.ChatSupportModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ChatSupportRepo extends JpaRepository<ChatSupportModel, Long> {
    Optional<ChatSupportModel> findByMobile(String mobile);
    List<ChatSupportModel> findAllByMobileOrderByTimestampAsc(String mobile);
    Optional<ChatSupportModel> findById(Long id);
}
