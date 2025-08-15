package ecommerce.example.ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ecommerce.example.ecommerce.model.ReportModel;

@Repository
public interface ReportRepo extends JpaRepository<ReportModel, Integer>{

}
