package com.agroshop.app.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agroshop.app.controller.request.GenericRequest;
import com.agroshop.app.controller.response.GenericResponse;
import com.agroshop.app.model.beans.CategoryProductBean;
import com.agroshop.app.model.service.ICategoryProductService;

@RestController
@RequestMapping("/categoryproduct")
public class CategoryProductController{
	@Autowired
	private ICategoryProductService categoryProductService;
	
	@PostMapping(path="/scp")
	public  GenericResponse<CategoryProductBean> saveCategoryProduct(@RequestBody GenericRequest<CategoryProductBean> request){
		GenericResponse<CategoryProductBean> response = new GenericResponse<CategoryProductBean>();
		try {
			//response.setData(this.categoryProductService.save(request.getData()));
			response.setResponseMessage("Producto registrado");
			response.setResponseCode(response.SUCCESS);
		}catch(Error e){} {
			response.setResponseMessage("Error al guardar categoria");
			response.setResponseCode(response.ERROR);
		}
		return response;
	}
}
