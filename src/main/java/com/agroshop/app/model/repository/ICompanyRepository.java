package com.agroshop.app.model.repository;

import java.util.List;

import com.agroshop.app.model.entities.CompanyEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ICompanyRepository extends JpaRepository<CompanyEntity, Integer> {
}
