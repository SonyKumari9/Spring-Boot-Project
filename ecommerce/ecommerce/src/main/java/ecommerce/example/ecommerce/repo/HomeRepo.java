package ecommerce.example.ecommerce.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ecommerce.example.ecommerce.model.HomeModel;

public interface HomeRepo extends JpaRepository<HomeModel, Long> {

    // Search by name (partial, case-insensitive)
    List<HomeModel> findByNameContainingIgnoreCase(String name);

    // Filter by category (exact, case-insensitive)
    List<HomeModel> findByCategoryIgnoreCase(String category);

    // Search by name + category
    List<HomeModel> findByNameContainingIgnoreCaseAndCategoryIgnoreCase(String name, String category);

    //  Partial match for category (if category string is part of the field)
    @Query("SELECT p FROM HomeModel p WHERE LOWER(p.category) LIKE LOWER(CONCAT('%', :category, '%'))")
    List<HomeModel> findByCategoryContainingIgnoreCase(@Param("category") String category);
}
