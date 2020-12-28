package com.agroshop.app.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.agroshop.app.model.entities.ContractEntity;
import com.agroshop.app.model.entities.DriverEntity;
import com.agroshop.app.model.entities.PostulationEntity;

@Service
public interface IContractService {
	
	public ContractEntity registerContract(ContractEntity contract) throws Throwable;
	
	public List<ContractEntity> getContracts() throws Throwable;
	
	public Boolean deleteContract(Integer id) throws Throwable;
	
	public ContractEntity enableContract(ContractEntity contract) throws Throwable;
	
	public String createContract(ContractEntity contract) throws Throwable;
	
	public String getContract(Integer id) throws Throwable;
	
}
