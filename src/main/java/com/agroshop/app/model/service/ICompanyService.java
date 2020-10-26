package com.agroshop.app.model.service;

import java.util.List;

import com.agroshop.app.model.entities.CompanyEntity;

import org.springframework.stereotype.Service;

@Service
public interface ICompanyService extends GenericCRUD<CompanyEntity, Integer>{
    CompanyEntity getCompanyById(Integer id);
}
