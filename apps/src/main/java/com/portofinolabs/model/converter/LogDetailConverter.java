package com.portofinolabs.model.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.portofinolabs.model.EndpointLog;
import com.portofinolabs.model.LogDetail;
import com.portofinolabs.model.LogSet;
import com.portofinolabs.model.Logs;

/**
 * This class was created to Convert {@link EndpointLog}
 * to custom objects.
 * 
 * @author matheus
 *
 */
@Component
public class LogDetailConverter {

	public LogDetail create(Iterable<EndpointLog> allEndpoints) {

		LogDetail detail = new LogDetail();
		LogSet logSet = new LogSet();
		List<Logs> logsList = new ArrayList<>();
		logSet.setEndpoint("hello-world");

		for (EndpointLog endpointLog : allEndpoints) {
			Logs log = new Logs();
			log.setIp(endpointLog.getIpAddress());
			log.setTimestamp(endpointLog.getTimestamp());
			logsList.add(log);
		}
		logSet.setLogs(logsList);
		List<LogSet> logSets = new ArrayList<>();
		logSets.add(logSet);
		detail.setLogset(logSets);
		return detail;
	}
	public LogSet createLogSet(Iterable<EndpointLog> allEndpoints) {
		
		LogSet logSet = new LogSet();
		List<Logs> logsList = new ArrayList<>();
		logSet.setEndpoint("hello-world");
		
		for (EndpointLog endpointLog : allEndpoints) {
			Logs log = new Logs();
			log.setIp(endpointLog.getIpAddress());
			log.setTimestamp(endpointLog.getTimestamp());
			logsList.add(log);
		}
		logSet.setLogs(logsList);
		List<LogSet> logSets = new ArrayList<>();
		logSets.add(logSet);
		return logSet;
	}

}
