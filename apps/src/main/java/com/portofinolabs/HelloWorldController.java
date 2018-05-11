package com.portofinolabs;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.portofinolabs.model.LogDetail;
import com.portofinolabs.model.LogSet;
import com.portofinolabs.model.Message;
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
	
	
	@RequestMapping(value = "/helloworld", method = RequestMethod.GET)
	@ResponseBody
	public String hello(){
		
		Message message = new Message();
		message.setMessage("Hello World!");
		try {
			endpointLogService.save(InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) {
			return "An error occured"+ e.getMessage();
		}
		return messageParser.parse(message);
	}
	
	@RequestMapping(value = "/logs", method = RequestMethod.GET)
	@ResponseBody
	public String listAllLogs(){
		LogDetail all = endpointLogService.findAll();
		return logParser.parse(all);
	}
	
	@RequestMapping(value = "/hello-world/logs", method = RequestMethod.GET)
	@ResponseBody
	public String listHelloWorldLogs(){
		LogSet allLogSets = endpointLogService.findAllLogSets();
		return logSetParser.parse(allLogSets);
	}
	
}
