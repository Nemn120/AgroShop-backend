package com.agroshop.app.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.agroshop.app.model.entities.CompanyEntity;

public interface ICompanyRepository extends JpaRepository<CompanyEntity, Integer> {

	List<CompanyEntity> findByStatus(String status);
	
}
