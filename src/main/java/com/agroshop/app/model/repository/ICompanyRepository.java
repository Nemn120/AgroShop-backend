package com.agroshop.app.model.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.agroshop.app.model.entities.CompanyEntity;

public interface ICompanyRepository extends JpaRepository<CompanyEntity, Integer> {
	List<CompanyEntity> findByStatus(String status);
}
