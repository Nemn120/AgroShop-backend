package com.agroshop.app.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agroshop.app.model.entities.JobOfferEntity;
import com.agroshop.app.model.repository.IJobOfferRepository;
import com.agroshop.app.model.service.IJobOfferService;

@Service
@Transactional
public class JobOfferServiceImpl implements IJobOfferService {
	
	@Autowired
	IJobOfferRepository jobOfferRepo;

	@Override
	public List<JobOfferEntity> getAll() {
		return jobOfferRepo.findAll();
	}

	@Override
	public JobOfferEntity getOneById(Integer id) {
		return jobOfferRepo.findById(id).orElse(new JobOfferEntity());
	}

	@Override
	public JobOfferEntity save(JobOfferEntity t) {
		return jobOfferRepo.save(t);
	}

	@Override
	public void deleteById(Integer id) {
		jobOfferRepo.deleteById(id);
	}

}
