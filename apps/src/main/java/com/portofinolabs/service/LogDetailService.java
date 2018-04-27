package com.portofinolabs.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portofinolabs.model.LogDetail;
import com.portofinolabs.model.LogSet;
import com.portofinolabs.model.Logs;
import com.portofinolabs.redis.repository.LogDetailRepository;

@Service
public class LogDetailService {

	@Autowired
	private LogDetailRepository repository;
	
	public void save(LogDetail logDetail){
		repository.save(logDetail);
	}
	
	public List<LogDetail> findAll(){
		List<LogDetail> allLogs = new ArrayList<>();
		repository.findAll().forEach(allLogs::add);
		return allLogs;
	}

	public void save(String remoteAddress) {
		LogDetail detail = createLogDetail(remoteAddress);
		repository.save(detail);
	}

	private LogDetail createLogDetail(String remoteAddress) {
		LogDetail detail = new LogDetail();
		LogSet logSet = new LogSet();
		Logs log = new Logs();
		log.setIp(remoteAddress);
		log.setTimestamp(new Date());
		List<Logs> logsList = new ArrayList<>();
		logsList.add(log);
		logSet.setEndpoint("hello-world");
		logSet.setLogs(logsList);
		List<LogSet> logSets = new ArrayList<>();
		logSets.add(logSet);
		detail.setLogset(logSets);
		return detail;
	}
	
}
