package com.portofinolabs.service;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.portofinolabs.model.EndpointLog;
import com.portofinolabs.model.LogDetail;
import com.portofinolabs.redis.repository.EndpointLogRepository;

@RunWith(SpringRunner.class)
public class EndpointLogServiceTest {

	@TestConfiguration
    static class EndpointLogServiceTestContextConfiguration {
  
        @Bean
        public EndpointLogService endpointLogService() {
            return new EndpointLogService();
        }
    }
	
	@Autowired
	private EndpointLogService endpointLogService;
	
	@MockBean
	private EndpointLogRepository endpointLogRepository;
	
//	@Test
	public void shouldFindAllEventLogs(){
		DateTime timestamp = DateTime.now()
				.withYear(2018)
				.withMonthOfYear(1)
				.withDayOfMonth(1)
				.withHourOfDay(1)
				.withMinuteOfHour(0)
				.withSecondOfMinute(0)
				.withMillisOfSecond(0);
		EndpointLog endpointLog = new EndpointLog();
		endpointLog.setId(1);
		endpointLog.setEndpoint("helloworld");
		endpointLog.setIpAddress("172.0.0.1");
		endpointLog.setTimestamp(timestamp.toDate());
		Iterable<EndpointLog> endpointLogs = new ArrayList<>();
		List<EndpointLog> logs = new ArrayList<>();
		logs.add(endpointLog);
		endpointLogs.forEach(logs::add);
		when(endpointLogRepository.findAll()).thenReturn(endpointLogs);
		LogDetail findAll = endpointLogService.findAll();
		
	}
	
}
