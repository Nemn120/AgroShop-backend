package com.agroshop.app.model.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agroshop.app.model.entities.DriverEntity;
import com.agroshop.app.model.entities.JobOfferEntity;
import com.agroshop.app.model.entities.PostulationEntity;
import com.agroshop.app.model.repository.IPostulationRepository;
import com.agroshop.app.model.service.IDriverService;
import com.agroshop.app.model.service.IJobOfferService;
import com.agroshop.app.model.service.IPostulationService;
import com.agroshop.app.util.Constants;

@Service
@Transactional
public class PostulationServiceImpl implements IPostulationService {

	private static final Logger logger = LogManager.getLogger(PostulationServiceImpl.class);

	@Autowired
	private IPostulationRepository postulationRepo;

	@Autowired
	private IJobOfferService jobOfferService;

	@Autowired
	private IDriverService driverService;

	@Override
	public List<PostulationEntity> getAll() {
		return postulationRepo.findAll();
	}

	@Override
	public PostulationEntity getOneById(Integer id) {
		return postulationRepo.findById(id).orElse(new PostulationEntity());
	}

	@Override
	public PostulationEntity save(PostulationEntity t) {
		return postulationRepo.save(t);
	}

	@Override
	public void deleteById(Integer id) {
		postulationRepo.deleteById(id);
	}

	@Override
	public String applyForAJob(Integer idJobOffer, Integer idDriver, String detail, String reply) throws Throwable {

		logger.info("PostulationServiceImpl.applyForAJob()");
		JobOfferEntity offer = new JobOfferEntity();
		DriverEntity driver = new DriverEntity();
		PostulationEntity postulation = new PostulationEntity();
		String message;
		String code;

		if (!existsPostulationForDriver(idJobOffer, idDriver)) {
			offer = jobOfferService.getOneById(idJobOffer);
			driver = driverService.getDriverById(idDriver);
			postulation.setJobOffer(offer);
			postulation.setDriver(driver);
			message = "Postulación exitosa";
			code = "1";
		} else {
			if (reply != null) {
				postulation = postulationRepo.findByIdJobOfferAndIdDriver(idJobOffer, idDriver);
				postulation.setReply(reply);
				message = "Has vuelto a postular";
				code = "2";
			} else {
				message = "Ya has postulado";
				code = "0";
			}
		}

		if (detail != null) {
			postulation.setDetail(detail);
		}
		
		postulation.setStatus(Constants.POSTULATION_STATUS_SEND);
		postulation.setHaveContract(false);
		postulation.setStatusPostulation(Constants.POSTULATION_RECEIVED_STATUS_PENDING);
		postulation.setPostulationDate(LocalDateTime.now());
		if(!code.equals("0")) {
			postulationRepo.save(postulation);
		}
		return message;
	}

	@Override
	public PostulationEntity findByIdJobOfferAndIdDriver(Integer idJobOffer, Integer idDriver) throws Throwable {
		return postulationRepo.findByIdJobOfferAndIdDriver(idJobOffer, idDriver);
	}

	@Override
	public boolean existsPostulationForDriver(Integer idJobOffer, Integer idDriver) throws Throwable {
		boolean exists = false;
		PostulationEntity post = postulationRepo.findByIdJobOfferAndIdDriver(idJobOffer, idDriver);
		if (post != null) {
			exists = true;
		}
		return exists;
	}

	@Override
	public void acceptPostulation(Integer id) throws Throwable {
		PostulationEntity postulation = new PostulationEntity();
		postulation = getOneById(id);
		if(!postulation.getStatusPostulation().equals("Aceptada")) {
			postulation.setStatusPostulation("Aceptada");
			save(postulation);
		}
	}
	
	public List<PostulationEntity> findByStatusPostulationAndDriverId(String statusPostulation, Integer driverId) throws Throwable {
		return postulationRepo.findByStatusPostulationAndDriverId(statusPostulation, driverId);
	}

	@Override
	public List<PostulationEntity> findPostulationByStatusPostulationAndFarmerId(String statusPostulation, Integer farmerId) throws Throwable {
		return postulationRepo.findByStatusPostulationAndFarmerId(statusPostulation, farmerId);
	}

}
