package com.portofinolabs.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.portofinolabs.model.EndpointLog;
import com.portofinolabs.redis.repository.EndpointLogRepository;

public class EndpointLogServiceTest {

	@InjectMocks
	private EndpointLogService endpointLogService;
	
	@Mock
	private EndpointLogRepository repository;
	
	private DateTime timestamp;
	private EndpointLog endpointLog;
	private EndpointIterable<EndpointLog> endpointLogs;
	private Iterable<EndpointLog> allEndpoints;
	
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		createTimeStamp();
	}
	
	private void createTimeStamp() {
		timestamp = DateTime.now()
				.withYear(2018)
				.withMonthOfYear(1)
				.withDayOfMonth(1)
				.withHourOfDay(1)
				.withMinuteOfHour(0)
				.withSecondOfMinute(0)
				.withMillisOfSecond(0);
	}

	@Test
	public void shouldFindAllEventLogs(){
		givenAnEndpoint();
		givenAnEndpointLogs();
		whenSearchForAllEndpoints();
		thenShouldReturnAllEndpoints();
	}

	private void thenShouldReturnAllEndpoints() {
		assertEquals(endpointLogs, allEndpoints);
	}

	private void whenSearchForAllEndpoints() {
		when(repository.findAll()).thenReturn(endpointLogs);
		allEndpoints = endpointLogService.findAll();
	}

	private void givenAnEndpointLogs() {
		List<EndpointLog> logs = new ArrayList<>();
		logs.add(endpointLog);
		endpointLogs = new EndpointIterable<>(logs);
	}

	private void givenAnEndpoint() {
		endpointLog = new EndpointLog();
		endpointLog.setId(1);
		endpointLog.setEndpoint("helloworld");
		endpointLog.setIpAddress("172.0.0.1");
		endpointLog.setTimestamp(timestamp.toDate());
	}
	
}
