package com.agroshop.app.controller.rest;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agroshop.app.controller.request.GenericRequest;
import com.agroshop.app.controller.response.AbstractResponse;
import com.agroshop.app.controller.response.GenericResponse;
import com.agroshop.app.model.beans.CompanyBean;
import com.agroshop.app.model.service.ICompanyService;
import com.agroshop.app.model.entities.CompanyEntity;

@RestController
@RequestMapping("/company")
public class CompanyController {
	
	String path = "http://localhost:8080/company";
	private static final Logger logger = LogManager.getLogger(CompanyController.class);	
	
	@Autowired
	private ICompanyService companyService;
	
	@PostMapping(path="/gclbs")
	public GenericResponse<CompanyBean> getCompanyListByStatus(@RequestBody GenericRequest<CompanyBean> request){
		
		GenericResponse<CompanyBean> response = new GenericResponse<CompanyBean>();
		try {
			CompanyBean bean = request.getData();
			List<CompanyBean> list = companyService.getCompanyListByStatus(bean); 
			if(list.isEmpty())
				response.setResponseMessage("No se encontraron empresas");
			else
				response.setResponseMessage("Se listó las empresas con exito");
			response.setDatalist(list);
			response.setFinalTimesTamp(LocalDateTime.now());
			response.setResponseCode(AbstractResponse.SUCCESS);
		}catch(Exception e) {
			response.setResponseMessage("Error al listar las empresas");
			response.setResponseCode(AbstractResponse.ERROR);
		}
		return response;
	}
	
	@PostMapping(path="/ac")
	public GenericResponse<CompanyBean> acceptCompany(@RequestBody GenericRequest<CompanyBean> request){

		GenericResponse<CompanyBean> response = new GenericResponse<CompanyBean>();
			
			if(request.getData() != null) {
				CompanyBean bean = request.getData();
				boolean res = companyService.acceptCompany(bean);
				if(res) { 
					logger.info(bean);
					response.setResponseMessage("Se aceptó la empresa con éxito");
					response.setResponseCode(AbstractResponse.SUCCESS);
				}
				else { 
					logger.info("Error:" + bean);
					response.setResponseMessage("Error al aceptar la empresa");					
					response.setResponseCode(AbstractResponse.ERROR);
				}
				
				
			}else if(!request.getDatalist().isEmpty()) {
			
				List<CompanyBean> list = companyService.acceptCompanyList(request.getDatalist());
				if(list.isEmpty()) {
					response.setResponseMessage("Se aceptó las empresas con éxito");
					response.setResponseCode(AbstractResponse.SUCCESS);
				}
				else {
					response.setResponseMessage("Error al aceptar algunas empresas");
					response.setResponseCode(AbstractResponse.ERROR);
				}
				response.setDatalist(list);
				
			}
			
			response.setFinalTimesTamp(LocalDateTime.now());
			return response;
	}

}
