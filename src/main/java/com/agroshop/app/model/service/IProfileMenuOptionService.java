package com.agroshop.app.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.agroshop.app.model.entities.ProfileMenuOptionEntity;

@Service
public interface IProfileMenuOptionService extends GenericCRUD<ProfileMenuOptionEntity, Integer>{
	List<ProfileMenuOptionEntity> getOptionsByProfileId(Integer profileId);
}
