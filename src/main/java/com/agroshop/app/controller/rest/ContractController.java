package com.agroshop.app.controller.rest;

import com.agroshop.app.controller.request.GenericRequest;
import com.agroshop.app.controller.response.AbstractResponse;
import com.agroshop.app.controller.response.GenericResponse;
import com.agroshop.app.model.entities.ContractEntity;
import com.agroshop.app.model.service.IContractService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contrato")
public class ContractController {

	@Autowired
	IContractService contractService;

	@PostMapping("/rcontract")
	public GenericResponse<String> registerContract(@RequestBody GenericRequest<ContractEntity> request)
			throws Throwable {
		GenericResponse<String> response = new GenericResponse<String>();
		ContractEntity contract = new ContractEntity();

		try {
			contract = request.getData();

			contract = contractService.enableContract(contract);
			String path = contractService.createContract(contract);
			contract.setFileContract(path);
			contractService.registerContract(contract);

			response.setData(path);
			response.setResponseCode(AbstractResponse.SUCCESS);
			response.setResponseMessage("Contrato generado");
		} catch (Error e) {
			response.setResponseCode(AbstractResponse.ERROR);
			response.setResponseMessage(e.getMessage());
		}

		return response;
	}

	@PostMapping("/dcontract")
	public GenericResponse<byte[]> dowloadContract(@RequestBody GenericRequest<Integer> request) throws Throwable {
		GenericResponse<byte[]> response = new GenericResponse<byte[]>();
		response.setData(contractService.obtenerContrato(request.getData()));
		response.setResponseCode(AbstractResponse.SUCCESS);
		response.setResponseMessage("Bytes generados");
		return response;
	}
}
