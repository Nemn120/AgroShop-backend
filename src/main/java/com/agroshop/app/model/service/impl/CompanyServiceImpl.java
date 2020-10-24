package com.agroshop.app.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agroshop.app.model.entities.ClientEntity;
import com.agroshop.app.model.entities.CompanyEntity;
import com.agroshop.app.model.repository.ICompanyRepository;
import com.agroshop.app.model.service.ICompanyService;

@Service
public class CompanyServiceImpl implements ICompanyService {
	
	@Autowired
	private ICompanyRepository companyRepo;
	
	@Override
	public List<CompanyEntity> getAll() {
		return companyRepo.findAll();
	}

	@Override
	public CompanyEntity getOneById(Integer id) {
		return companyRepo.findById(id).orElse(new CompanyEntity());
	}

	@Override
	public CompanyEntity save(CompanyEntity t) {
		return companyRepo.save(t);
	}

	@Override
	public void deleteById(Integer id) {
		companyRepo.deleteById(id);
	}

}
