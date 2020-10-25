package com.agroshop.app.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.agroshop.app.model.beans.CompanyBean;
import com.agroshop.app.model.entities.CompanyEntity;

@Service
public interface ICompanyService extends GenericCRUD<CompanyEntity, Integer>{

	List<CompanyBean> getCompanyListByStatus(CompanyBean bean);
}
