package com.cts.fms;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.math.BigInteger;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.cts.fms.batch.model.EventDetails;
import com.cts.fms.event.controler.EventControler;
import com.cts.fms.event.model.EventModel;
import com.cts.fms.event.model.EventModelResponse;
import com.cts.fms.event.service.FmsMasterService;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc 
class CtsFmsApplicationTests {

	@LocalServerPort
	int randomServerPort;
	@Autowired
	private EventControler eventController;
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;
	@Autowired(required=true)
	private MockMvc mockMvc;

	@MockBean
	private FmsMasterService service;

	@Test
	void getEventData() throws URISyntaxException {
		
		
		    RestTemplate restTemplate = new RestTemplate();
	        final String baseUrl = "http://localhost:"+randomServerPort+"/eventData/";
	        URI uri = new URI(baseUrl);
	        
	        HttpHeaders headers = new HttpHeaders();
	        headers.set("X-COM-LOCATION", "USA");
	 
	        HttpEntity<EventModel> requestEntity = new HttpEntity<>(null, headers);
	        
	        try
	        {
	            restTemplate.exchange(uri, HttpMethod.GET, requestEntity, String.class);
	            Assertions.fail();
	        }
	        catch(HttpClientErrorException ex) 
	        {
	            //Verify bad request and missing header
	            Assertions.assertEquals(401, ex.getRawStatusCode());
	            Assertions.assertEquals(false, ex.getResponseBodyAsString().contains("Missing request header"));
	        }
	}
	
	@Test
	public void contexLoads() throws Exception {
		assertThat(eventController).isNotNull();
	}
	@Test
	public void getEventDataActualCall() throws Exception {
		EventModelResponse response = new EventModelResponse();
		EventModel ref = new EventModel();
		ObjectMapper mapper = new ObjectMapper();
		ref.setLivesImpacted(0.0);
		ref.setTotalEvent(null);
		ref.setTotalPrticipants(0.0);
		ref.setTotalVolunteers(0);
		response.setMessage("success");
		response.setEventData(ref);
		
		String jsonString = mapper.writeValueAsString(response);
		
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/eventData",
				String.class)).contains(jsonString);
	}
	
	@Test
	public void eventDashboardMock() throws Exception {
		ResultMatcher ok = MockMvcResultMatchers.status().isOk();
		List<EventDetails> list =new ArrayList<EventDetails>();
		when(service.getEventDetails()).thenReturn(list);
		this.mockMvc.perform(get("/eventDashboard")).andDo(print()).andExpect(status().isOk());
				
	}

}
