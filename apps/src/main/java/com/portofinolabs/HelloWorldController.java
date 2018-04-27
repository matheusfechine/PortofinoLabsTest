package com.portofinolabs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.portofinolabs.model.Message;
import com.portofinolabs.model.parser.EntityParser;
import com.portofinolabs.service.LogDetailService;

@Controller
@RequestMapping("/v1")
public class HelloWorldController {

	@Autowired
	private EntityParser<Message> messageParser;
	
	@Autowired
	private LogDetailService service;
	
	@RequestMapping(value = "/helloworld", method = RequestMethod.GET)
	@ResponseBody
	public String hello(){
		
		String remoteAddress = 
				((ServletRequestAttributes)RequestContextHolder
						.currentRequestAttributes())
			       .getRequest()
			       .getRemoteAddr();
		
		Message message = new Message();
		message.setMessage("Hello World!");
		service.save(remoteAddress);
		return messageParser.parse(message);
	}
	
}
