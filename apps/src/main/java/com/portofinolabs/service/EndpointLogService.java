package com.portofinolabs.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portofinolabs.model.EndpointLog;
import com.portofinolabs.model.LogDetail;
import com.portofinolabs.model.LogSet;
import com.portofinolabs.model.converter.LogDetailConverter;
import com.portofinolabs.redis.repository.EndpointLogRepository;

@Service
public class EndpointLogService {

	@Autowired
	private EndpointLogRepository repository;
	
	@Autowired
	private LogDetailConverter converter;
	
	public void save(String remoteAddress) {
		EndpointLog endpointLog = new EndpointLog();
		endpointLog.setEndpoint("hello-world");
		endpointLog.setIpAddress(remoteAddress);
		endpointLog.setTimestamp(new Date());
		repository.save(endpointLog);
	}
	
	
	public LogDetail findAll() {
		Iterable<EndpointLog> allEndpoints = repository.findAll();
		return converter.create(allEndpoints);
	}


	public LogSet findAllLogSets() {
		Iterable<EndpointLog> allEndpoints = repository.findAll();
		return converter.createLogSet(allEndpoints);
	}
	
	
}
