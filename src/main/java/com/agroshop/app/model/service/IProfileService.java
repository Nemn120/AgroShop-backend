package com.agroshop.app.model.service;

import org.springframework.stereotype.Service;

import com.agroshop.app.model.entities.ProfileEntity;

@Service
public interface IProfileService extends GenericCRUD<ProfileEntity, Integer>{

}
