package com.portofinolabs.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portofinolabs.model.EndpointLog;
import com.portofinolabs.redis.repository.EndpointLogRepository;

@Service
public class EndpointLogService {

	@Autowired
	private EndpointLogRepository repository;
	
	public void save(String remoteAddress) {
		EndpointLog endpointLog = new EndpointLog();
		endpointLog.setEndpoint("hello-world");
		endpointLog.setIpAddress(remoteAddress);
		endpointLog.setTimestamp(new Date());
		repository.save(endpointLog);
	}
	

	public Iterable<EndpointLog> findAll() {
		return repository.findAll();
	}
	
	
}
