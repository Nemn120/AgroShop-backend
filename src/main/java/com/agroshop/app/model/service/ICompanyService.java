package com.agroshop.app.model.service;

import java.util.List;

import com.agroshop.app.model.entities.CompanyEntity;

import org.springframework.stereotype.Service;

@Service
public interface ICompanyService extends GenericCRUD<CompanyEntity, Integer>{

	List<CompanyEntity> getCompanyListByStatus(CompanyEntity company);
	
	Boolean acceptCompany(CompanyEntity company); 
	
	List<CompanyEntity> acceptCompanyList(List<CompanyEntity> company);
    CompanyEntity getCompanyById(Integer id);
}
