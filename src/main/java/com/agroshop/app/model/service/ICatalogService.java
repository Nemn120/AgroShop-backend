package com.agroshop.app.model.service;

import org.springframework.stereotype.Service;

import com.agroshop.app.model.entities.CatalogEntity;

@Service
public interface ICatalogService extends GenericCRUD<CatalogEntity, Integer>{

}
