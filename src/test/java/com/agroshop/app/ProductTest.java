package com.agroshop.app;

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
import com.agroshop.app.model.entities.ProductEntity;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class ProductTest {

	@Autowired
	  private WebApplicationContext wac;
	@Autowired
	  private MockMvc mockMvc;
	  
	
	@BeforeTestExecution
	public void setUp() {
		 this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

	}
	
	@Test
	void getListProductByFarmer() throws Exception{
		GenericRequest<ProductEntity> request = new GenericRequest<>();
		ProductEntity pr = new ProductEntity();
		pr.setUserCreateId(1);
		request.setData(pr);
		mockMvc.perform(
			      post("/product/glpbf")
			      .contentType(org.springframework.http.MediaType.APPLICATION_JSON)
			      .accept(org.springframework.http.MediaType.APPLICATION_JSON)
			      .content(asJsonString(request)))
      .andDo(print())
		.andExpect(MockMvcResultMatchers.jsonPath("$.responseCode").value(AbstractResponse.SUCCESS))
		.andExpect(MockMvcResultMatchers.jsonPath("$.responseMessage").value("productos mostrados exitosamente"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.datalist").isNotEmpty());	
	}
	
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}

}
