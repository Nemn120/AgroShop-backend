package com.agroshop.app;

import static org.junit.jupiter.api.Assertions.*;
//import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestExecution;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.agroshop.app.controller.request.GenericRequest;
import com.agroshop.app.controller.response.AbstractResponse;
import com.agroshop.app.controller.rest.ProductSalesController;
import com.agroshop.app.model.entities.ProductEntity;
import com.agroshop.app.model.entities.ProductSalesEntity;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest
@AutoConfigureMockMvc
class ProductSalesTest {

	
	  @Autowired
	  private WebApplicationContext wac;
	  @Autowired
	  private MockMvc mockMvc;
	  @Autowired
	  private ProductSalesController pro;
	  
	@BeforeTestExecution
	public void setUp() {
		// this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).apply(springSecurity()).build();
		 this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

	}
	
	@Test
	void getListSearchProductSalesWhenProductSalesExist() throws Exception{

		
		GenericRequest<ProductSalesEntity> r = new GenericRequest<ProductSalesEntity>();
		ProductEntity p = new ProductEntity();
		p.setName("papas");
		ProductSalesEntity pr = new ProductSalesEntity();
		pr.setProduct(p);
		r.setData(pr);
		assertEquals(r.getData().getProduct().getName(),"papas");
		
		//Response = controller.getVehicleListByDriver(request);
		//Mockito.when(service.getVehicleListByDriver(1)).thenReturn(httpResponse.getDatalist());
		
		
			//MvcResult mvcResult = 
		/*			mockMvc.perform(
				      post("/productsales/glsps")
				      .contentType(org.springframework.http.MediaType.APPLICATION_JSON)
				      .accept(org.springframework.http.MediaType.APPLICATION_JSON)
				      .content(asJsonString(r)))
            .andDo(print())
			.andExpect(MockMvcResultMatchers.jsonPath("$.responseCode").value(AbstractResponse.SUCCESS));*/
			//.andExpect(MockMvcResultMatchers.jsonPath("$.dataMap").isNotEmpty())
			//.andExpect(MockMvcResultMatchers.jsonPath("$.responseMessage").value("Se encontró el producto buscado"));
			//.andReturn();
			//assertEquals("application/json;charset=UTF-8", 
				//      mvcResult.getResponse().getContentType());
			      
		assertEquals("Se encontró el producto buscado",pro.getListSearchProductSales(r).getResponseMessage());
	}
	
	@Test
	void getListSearchProductSalesWhenProductSalesDoesNotExist() throws Exception{

		
		GenericRequest<ProductSalesEntity> r = new GenericRequest<ProductSalesEntity>();
		ProductEntity p = new ProductEntity();
		p.setName("piedras");
		ProductSalesEntity pr = new ProductSalesEntity();
		pr.setProduct(p);
		r.setData(pr);
		//assertEquals(r.getData().getProduct().getName(),"lechugas");
		
					mockMvc.perform(
				      post("/productsales/glsps")
				      .contentType(org.springframework.http.MediaType.APPLICATION_JSON)
				      .accept(org.springframework.http.MediaType.APPLICATION_JSON)
				      .content(asJsonString(r)))
            .andDo(print())
			.andExpect(MockMvcResultMatchers.jsonPath("$.responseCode").value(AbstractResponse.SUCCESS))
			.andExpect(MockMvcResultMatchers.jsonPath("$.responseMessage").value("No se encontraron productos"))
			.andExpect(MockMvcResultMatchers.jsonPath("$.dataMap").isEmpty());		      

	}
	
	@Test
	void getListSearchProductSalesWhenProductSalesIsIncorrect() throws Exception{

		
		GenericRequest<ProductSalesEntity> r = new GenericRequest<ProductSalesEntity>();
		ProductEntity p = new ProductEntity();
		ProductSalesEntity pr = new ProductSalesEntity();
		pr.setProduct(p);
		r.setData(pr);
		
					mockMvc.perform(
				      post("/productsales/glsps")
				      .contentType(org.springframework.http.MediaType.APPLICATION_JSON)
				      .accept(org.springframework.http.MediaType.APPLICATION_JSON)
				      .content(asJsonString(r)))
            .andDo(print())
			.andExpect(MockMvcResultMatchers.jsonPath("$.responseCode").value(AbstractResponse.SUCCESS))
			.andExpect(MockMvcResultMatchers.jsonPath("$.responseMessage").value("No se encontraron productos"))
			.andExpect(MockMvcResultMatchers.jsonPath("$.dataMap").isEmpty());		      

	}
	
	
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}

}
