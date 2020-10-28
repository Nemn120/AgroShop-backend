package com.agroshop.app.model.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agroshop.app.model.beans.CompanyBean;
import com.agroshop.app.model.entities.ClientEntity;
import com.agroshop.app.model.entities.CompanyEntity;
import com.agroshop.app.model.repository.ICompanyRepository;
import com.agroshop.app.model.service.ICompanyService;
import com.agroshop.app.model.service.IUserService;
import com.agroshop.app.util.Constants;

@Service
public class CompanyServiceImpl implements ICompanyService {

	@Autowired
	private ICompanyRepository companyRepo;
	
	@Autowired
	private IUserService userService;
	

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

	@Override
	public List<CompanyEntity> getCompanyListByStatus(CompanyEntity company) {
		List<CompanyEntity> list = companyRepo.findByStatus(company.getStatus());
		return list;
	}

	@Override
	public Boolean acceptCompany(CompanyEntity comp) {
		try {
			CompanyEntity company = getOneById(comp.getId());
			if(company.getCreateDate()!=null) {
				company.setStatus(Constants.COMPANY_STATUS__ACCEPTED);
				save(company);
				userService.acceptUser(comp.getId());
				return true;
			}else
				throw new RuntimeException("Empresa no encontrada");
		}catch(Exception e) {
			return false;
		}
	}

	@Override
	public List<CompanyEntity> acceptCompanyList(List<CompanyEntity> beans) {
		
		List<CompanyEntity> rejected = new ArrayList<CompanyEntity>() ;
		
			
			for(CompanyEntity bean : beans) {
				if(!acceptCompany(bean) && !userService.acceptUser(bean.getId()))
					rejected.add(bean);
			}
			
			return rejected;
		}
		
	public CompanyEntity getCompanyById(Integer id) {
		return companyRepo.findById(id).orElse(null);
	}

}
