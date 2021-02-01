package com.agroshop.app.model.service;

import java.nio.file.Path;
import java.util.List;

import com.agroshop.app.model.entities.ContractEntity;

import org.springframework.stereotype.Service;

@Service
public interface IContractService {
	
	public ContractEntity registerContract(ContractEntity contract) throws Throwable;
	
	public List<ContractEntity> getContracts() throws Throwable;
	
	public Boolean deleteContract(Integer id) throws Throwable;
	
	public ContractEntity enableContract(ContractEntity contract) throws Throwable;
	
	public String createContract(ContractEntity contract) throws Throwable;
	
	public byte[] getContract(Integer id) throws Throwable;
	
	public ContractEntity findByPostulationId(Integer postulationId) throws Throwable;
	
	public Path getPath(String nameFile) throws Throwable;
	
}
