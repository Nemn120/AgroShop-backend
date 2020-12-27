package com.agroshop.app.controller.rest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agroshop.app.controller.request.GenericRequest;
import com.agroshop.app.controller.response.GenericResponse;
import com.agroshop.app.model.entities.ContractEntity;
import com.agroshop.app.model.service.IContractService;

@RestController
@RequestMapping("/api/contrato")
public class ContractController {
	
	@Autowired
	IContractService contractService;
	
	private GenericResponse<?> response;
	
	private static final Logger logger = LogManager.getLogger(DriverController.class);
	
	@PostMapping("/rcontract")
	public GenericResponse<?> registrarContrato(@RequestBody GenericRequest<ContractEntity> request) throws Throwable {
		this.response = new GenericResponse<String>();
		try {
			ContractEntity contrato = contractService.enableContract(request.getData());
			String ruta = contractService.createContract(contrato.getId());
			
			contrato.setFileContract(ruta);
			// serviceContrato.modificar(contrato);
			response.setResponseMessage("Contrato generado");
		} catch (DataAccessException e) {
			response.setResponseMessage(e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
		} catch (Exception e) {
			response.setResponseMessage(e.getMessage());
		}
		
		return response;
	}
	
	@PostMapping("/dContract")
	public byte[] descargarContrato(@RequestBody GenericRequest<Integer> request) throws Throwable {
		return contractService.getContract(request.getData());
	}
	
}
