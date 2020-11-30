package com.agroshop.app.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.agroshop.app.model.entities.PostulationEntity;

public interface IPostulationRepository extends JpaRepository<PostulationEntity, Integer>{
	
	@Query("SELECT postulation FROM PostulationEntity postulation WHERE  postulation.jobOffer.id=:idJobOffer AND postulation.driver.id=:idDriver")
	PostulationEntity findByIdJobOfferAndIdDriver(@Param("idJobOffer")Integer idJobOffer, @Param("idDriver")Integer idDriver);
	
	List<PostulationEntity> findByStatusPostulation(String statusPostulation);
	
}
