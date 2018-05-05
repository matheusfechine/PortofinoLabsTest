package com.portofinolabs.model.converter;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.portofinolabs.model.EndpointLog;
import com.portofinolabs.model.LogDetail;
import com.portofinolabs.model.LogSet;
import com.portofinolabs.model.Logs;

public class LogDetailConverterTest {

	private LogDetailConverter converter;
	
	private EndpointLog log1;
	private EndpointLog log2;
	private LogDetail actualLogDetail;
	private LogDetail expectedLogDetail;
	
	@Before
	public void setUp() {
		converter = new LogDetailConverter();
		createExpectedLogDetail();
	}
	
	private void createExpectedLogDetail() {
		expectedLogDetail = new LogDetail();
		expectedLogDetail.setLogset(new ArrayList<>());
		LogSet logSet1 = new LogSet();
		logSet1.setEndpoint("hello-world");
		logSet1.setLogs(new ArrayList<>());
		Logs log1 = new Logs();
		log1.setIp("172.0.0.1");
		Logs log2 = new Logs();
		log2.setIp("172.0.0.2");
		logSet1.getLogs().add(log2);
		logSet1.getLogs().add(log1);
		expectedLogDetail.getLogset().add(logSet1);
	}

	@Test
	public void itShouldConvertEndpointsToLogDetail() {
		givenOneEndpointLog();
		givenAnotherEndpointLog();
		whenTryToConvert();
		thenItShoulConvert();
	}

	private void thenItShoulConvert() {
		assertEquals(expectedLogDetail, actualLogDetail);
	}

	private void whenTryToConvert() {
		actualLogDetail = converter.create(Arrays.asList(log1, log2));
	}

	private void givenAnotherEndpointLog() {
		log2 = new EndpointLog();
		log2.setId(2);
		log2.setEndpoint("hello-world");
		log2.setIpAddress("172.0.0.1");
	}

	private void givenOneEndpointLog() {
		log1 = new EndpointLog();
		log1.setId(1);
		log1.setEndpoint("hello-world");
		log1.setIpAddress("172.0.0.2");
	}
	
}
