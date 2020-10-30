package com.agroshop.app.controller.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.agroshop.app.controller.request.GenericRequest;
import com.agroshop.app.controller.response.AbstractResponse;
import com.agroshop.app.controller.response.GenericResponse;
import com.agroshop.app.model.entities.VehicleEntity;
import com.agroshop.app.model.service.IVehicleService;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

	String path = "http://localhost:8080/vehicle";
	
	@Autowired
	private IVehicleService vehicleService;
	
	@PostMapping(path="/sv")
	public GenericResponse<VehicleEntity> saveVehicle(@RequestPart GenericRequest<VehicleEntity> request, @RequestPart("file") MultipartFile file){
		
		GenericResponse<VehicleEntity> response = new GenericResponse<VehicleEntity>();
		try {
			if(file.getBytes().length >0)
				request.getData().setPhoto(file.getBytes());
			response.setData(vehicleService.save(request.getData()));
			response.setResponseMessage("Vehiculo registrado exitosamente");
			response.setFinalTimesTamp(LocalDateTime.now());
			response.setResponseCode(AbstractResponse.SUCCESS);
		}catch(Exception e) {
			response.setResponseMessage("Error al registrar vehiculo");
			response.setResponseCode(AbstractResponse.ERROR);
		}
		return response;
	}
	
	@PostMapping(path="/dv")
	public GenericResponse<VehicleEntity> deleteVehicle(@RequestBody GenericRequest<VehicleEntity> request){
		
		GenericResponse<VehicleEntity> response = new GenericResponse<VehicleEntity>();
		try {
			vehicleService.deleteById(request.getData().getId());
			response.setResponseMessage("Vehiculo eliminado exitosamente");
			response.setFinalTimesTamp(LocalDateTime.now());
			response.setResponseCode(AbstractResponse.SUCCESS);
		}catch(Exception e) {
			response.setResponseMessage("Error al eliminar vehiculo");
			response.setResponseCode(AbstractResponse.ERROR);
		}
		
		
		return response;
	}
	
}