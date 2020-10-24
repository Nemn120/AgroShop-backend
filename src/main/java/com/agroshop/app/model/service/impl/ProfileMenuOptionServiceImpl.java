package com.agroshop.app.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.agroshop.app.model.entities.ProfileMenuOptionEntity;
import com.agroshop.app.model.repository.IProfileMenuOptionRepository;
import com.agroshop.app.model.service.IProfileMenuOptionService;

@Service
public class ProfileMenuOptionServiceImpl implements IProfileMenuOptionService {

	@Autowired
	private IProfileMenuOptionRepository profileMenuOptionRepo;

	@Override
	public List<ProfileMenuOptionEntity> getAll() {
		return profileMenuOptionRepo.findAll();
	}

	@Override
	public ProfileMenuOptionEntity getOneById(Integer id) {
		return profileMenuOptionRepo.getOne(id);
	}

	@Override
	public ProfileMenuOptionEntity save(ProfileMenuOptionEntity t) {
		return profileMenuOptionRepo.save(t);
	}

	@Override
	public void deleteById(Integer id) {
		profileMenuOptionRepo.deleteById(id);
	}

	
	
	

}
