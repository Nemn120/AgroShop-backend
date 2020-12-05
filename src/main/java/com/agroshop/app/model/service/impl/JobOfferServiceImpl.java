package com.agroshop.app.model.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agroshop.app.model.entities.JobOfferEntity;
import com.agroshop.app.model.repository.IJobOfferRepository;
import com.agroshop.app.model.service.IJobOfferService;

import com.agroshop.app.controller.rest.JobOfferController;
import com.agroshop.app.model.DTO.SearchJobOfferByFieldsDTO;
import com.agroshop.app.model.entities.JobOfferEntity;
import com.agroshop.app.model.entities.OrderDetailEntity;
import com.agroshop.app.model.entities.OrderEntity;
import com.agroshop.app.model.repository.IJobOfferRepository;
import com.agroshop.app.model.repository.IOrderDetailRepository;
import com.agroshop.app.model.repository.IOrderRepository;
import com.agroshop.app.model.service.IJobOfferService;
import com.agroshop.app.util.Constants;

@Service
@Transactional
public class JobOfferServiceImpl implements IJobOfferService{

	private static final Logger logger = LogManager.getLogger(JobOfferServiceImpl.class);
	@Autowired
	private IJobOfferRepository repo;
	
	@Autowired
	private IOrderDetailRepository OrderDetailrepo;
	
	@Autowired
	private IOrderRepository Orderrepo;
	
	@Override
	public List<JobOfferEntity> getAll() {
		return repo.findAll();
	}

	@Override
	public JobOfferEntity getOneById(Integer id) {

		return repo.findById(id).orElse(new JobOfferEntity());
	}

	@Override
	public JobOfferEntity save(JobOfferEntity t) {
		return repo.save(t);
	}

	@Override
	public void deleteById(Integer id) {
		repo.deleteById(id);
		
	}

	@Override
	public JobOfferEntity postOffer(JobOfferEntity job) throws Throwable{
		logger.info("orderdetail: " + OrderDetailrepo.findByOrderId(job.getOrder().getId()).size());
		OrderEntity or = Orderrepo.findById(job.getOrder().getId()).orElse(new OrderEntity());
		
		if (or.getCreateDate()==null)
			throw new RuntimeException("La order "+ job.getOrder().getId()+ " no tiene datos consistentes");
		
		or.setStatus(Constants.ORDER_STATUS_PUBLISHED);
		or.setReference(or.getReference().toLowerCase());
		Orderrepo.save(or);
		job.setOrder(or);
		LocalDate date = LocalDate.now();
		job.setStartDate(date);
		job.setStatusOffer(Constants.JOB_OFFER_AVAILABLE);
		List<OrderDetailEntity> details = OrderDetailrepo.findByOrderId(job.getOrder().getId());
		
		Double pesoTotal= details.stream()
			      .mapToDouble(o -> (Double.parseDouble(o.getProductSales().getWeight()) * o.getQuantity()))
			      .sum();
		logger.info("peso: " + pesoTotal);
		job.setTotalWeight(pesoTotal);
		
		repo.save(job);
		return job;
		
	}

	@Override
	public List<JobOfferEntity> getListJobOfferByFields(SearchJobOfferByFieldsDTO sjobf) {
		LocalDate date = LocalDate.now();
		logger.info("date: " + date);
		return repo.getListJobOfferByFields(sjobf,date);
	}

}
