package com.portofinolabs;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.portofinolabs.model.EndpointLog;
import com.portofinolabs.model.LogDetail;
import com.portofinolabs.model.LogSet;
import com.portofinolabs.model.Message;
import com.portofinolabs.model.converter.LogDetailConverter;
import com.portofinolabs.model.parser.EntityParser;
import com.portofinolabs.service.EndpointLogService;

@Controller
@RequestMapping("/v1")
public class HelloWorldController {

	@Autowired
	private EntityParser<Message> messageParser;
	
	@Autowired
	private EntityParser<LogDetail> logParser;
	
	@Autowired
	private EntityParser<LogSet> logSetParser;
	
	@Autowired
	private EndpointLogService endpointLogService;
	
	@Autowired
	private LogDetailConverter converter;
	
	
	@RequestMapping(value = "/helloworld", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> hello(){
		
		Message message = new Message();
		message.setMessage("Hello World!");
		try {
			endpointLogService.save(InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) {
			return new ResponseEntity<>("An error occured "+ e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(messageParser.parse(message), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/logs", method = RequestMethod.GET)
	@ResponseBody
	public String listAllLogs(){
		Iterable<EndpointLog> allEndpoints = endpointLogService.findAll();
		LogDetail logSet = converter.create(allEndpoints);
		return logParser.parse(logSet);
	}
	
	@RequestMapping(value = "/hello-world/logs", method = RequestMethod.GET)
	@ResponseBody
	public String listHelloWorldLogs(){
		Iterable<EndpointLog> allEndpoints = endpointLogService.findAll();
		LogSet logSet = converter.createLogSet(allEndpoints);
		return logSetParser.parse(logSet);
	}
	
}
