package com.agroshop.app.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agroshop.app.model.entities.ProfileEntity;
import com.agroshop.app.model.repository.IProfileRepository;
import com.agroshop.app.model.service.IProfileService;

@Service
public class ProfileServiceImpl implements IProfileService{

	@Autowired
	private IProfileRepository profileRepo;
	
	@Override
	public List<ProfileEntity> getAll() {
		return profileRepo.findAll();
	}

	@Override
	public ProfileEntity getOneById(Integer id) {
		return profileRepo.getOne(id);
	}

	@Override
	public ProfileEntity save(ProfileEntity t) {
		return profileRepo.save(t);
	}

	@Override
	public void deleteById(Integer id) {
		profileRepo.deleteById(id);
	}
}
