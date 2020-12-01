package com.agroshop.app.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agroshop.app.model.entities.JobProfileEntity;
import com.agroshop.app.model.repository.IJobProfileRepository;
import com.agroshop.app.model.service.IJobProfileService;

@Service
@Transactional
public class JobProfileServiceImpl implements IJobProfileService{
	
	@Autowired
	private IJobProfileRepository repo;

	@Override
	public List<JobProfileEntity> getAll() {
		return repo.findAll();
	}

	@Override
	public JobProfileEntity getOneById(Integer id) {
		return repo.findById(id).orElse(new JobProfileEntity());
	}

	@Override
	public JobProfileEntity save(JobProfileEntity t) {
		return repo.save(t);
	}

	@Override
	public void deleteById(Integer id) {
		repo.deleteById(id);
		
	}

	@Override
	public JobProfileEntity findByDriverId(Integer id) {
		return repo.findByDriverId(id);
	}
	
	

}
