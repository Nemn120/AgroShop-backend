package com.agroshop.app.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agroshop.app.model.entities.ContractEntity;
import com.agroshop.app.model.entities.PostulationEntity;

public interface IContractRepository extends JpaRepository<ContractEntity, Integer>{
	
	public List<ContractEntity> findByPostulation(PostulationEntity postulation);
	
	public ContractEntity findByPostulationId(Integer postulationId);
}
