package com.portofinolabs;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.portofinolabs.model.Message;
import com.portofinolabs.model.parser.EntityParser;

@RunWith(MockitoJUnitRunner.class)
public class HelloWorldControllerTest {

	private MockMvc mockMvc;
	
	@Mock
	private EntityParser<Message> messageParser;
	
	@InjectMocks
	private HelloWorldController controller;

	
	public void setUp(){
		this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	@Test
	public void itShouldSerializeHelloWorld(){
		
//		this.mockMvc.perform(get("/v1/helloworld")
//				.accept(MediaType.parseMediaType("application/json;charset=UTF-8")));
	}
}
