package com.agroshop.app;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import com.agroshop.app.model.DTO.SearchOrderByFieldsDTO;
import com.agroshop.app.model.entities.OrderEntity;
import com.agroshop.app.model.entities.ProductEntity;
import com.agroshop.app.model.entities.ProductSalesEntity;
import com.agroshop.app.util.Constants;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class OrderTest {

	 @Autowired
	  private WebApplicationContext wac;
	  @Autowired
	  private MockMvc mockMvc;
	  
	  @BeforeTestExecution
		public void setUp() {
			// this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).apply(springSecurity()).build();
			 this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

		}
	  
	  @Test
		void getListSearchOrderWhenFarmerExist() throws Exception{

			
			GenericRequest<SearchOrderByFieldsDTO> r = new GenericRequest<SearchOrderByFieldsDTO>();
			SearchOrderByFieldsDTO dto = new SearchOrderByFieldsDTO();
			dto.setFarmer(1);
			r.setData(dto);
			
						mockMvc.perform(
					      post("/order/globf")
					      .contentType(org.springframework.http.MediaType.APPLICATION_JSON)
					      .accept(org.springframework.http.MediaType.APPLICATION_JSON)
					      .content(asJsonString(r)))
	            .andDo(print())
				.andExpect(MockMvcResultMatchers.jsonPath("$.responseCode").value(Constants.SUCCESS_SHOW_LIST))
				.andExpect(MockMvcResultMatchers.jsonPath("$.responseMessage").value("Ordenes encontradas"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.datalist").isNotEmpty());		      

		}
	  
	  
	  @Test 
	  void getOrderListByStatusPendingAndClientIdWhenClientHasOrder() throws Exception{
		  GenericRequest<OrderEntity> r = new GenericRequest<OrderEntity>();
		  r.setId(1);
		  mockMvc.perform(
			      post("/order/golbspac")
			      .contentType(org.springframework.http.MediaType.APPLICATION_JSON)
			      .accept(org.springframework.http.MediaType.APPLICATION_JSON)
			      .content(asJsonString(r)))
		        .andDo(print())
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.datalist").isNotEmpty())
				.andExpect(MockMvcResultMatchers.jsonPath("$.responseCode").value(Constants.SUCCESS_SHOW_LIST));
	  }
	  
	  @Test
	  void cancelOrderWhenTimeExceeded() throws Exception{
		  GenericRequest<OrderEntity> r = new GenericRequest<OrderEntity>();
		  r.setId(20);
		  
		  mockMvc.perform(
			      post("/order/cor")
			      .contentType(org.springframework.http.MediaType.APPLICATION_JSON)
			      .accept(org.springframework.http.MediaType.APPLICATION_JSON)
			      .content(asJsonString(r)))
		        .andDo(print())
				.andExpect(status().isInternalServerError())
				.andExpect(MockMvcResultMatchers.jsonPath("$.responseMessage").value("Error al cancelar la orden, "
						+ "el pedido excedió el limite de tiempo permitido"));
		  
	  }


	 
	  
	  
		public static String asJsonString(final Object obj) {
		    try {
		        return new ObjectMapper().writeValueAsString(obj);
		    } catch (Exception e) {
		        throw new RuntimeException(e);
		    }
		}
}
