package com.portofinolabs.model.parser;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.junit.Test;

import com.portofinolabs.model.LogDetail;
import com.portofinolabs.model.LogSet;
import com.portofinolabs.model.Logs;

public class EntityParserTest {

	private DateTime dateTime;
	private Logs log1;
	private LogSet logSet1;
	private LogDetail detail;
	private List<LogSet> logSetList;
	private String actualLog;
	private String expectedLog;
	
	private EntityParser<LogDetail> parser;
	
	@Test
	public void shouldParseLogEntityToJson(){
		givenAParser();
		givenADate();
		givenALog();
		givenALogSet();
		givenALogDetail();
		whenTryToParseToJson();
		thenShouldParseEntityToJson();
	}

	private void givenAParser() {
		parser = new EntityParser<>();
	}

	private void thenShouldParseEntityToJson() {
		expectedLog = "{\"logset\":[{\"endpoint\":\"hello-world\",\"logs\":[{\"ip\":\"172.0.0.1\",\"timestamp\":\"Apr 1, 2018 10:10:00 AM\"}]}]}";
		assertEquals(actualLog, expectedLog);
	}

	private void whenTryToParseToJson() {
		actualLog = parser.parse(detail);
	}


	private void givenALogDetail() {
		detail = new LogDetail();
		detail.setLogset(logSetList);
	}


	private void givenALogSet() {
		logSet1 = new LogSet();
		logSet1.setEndpoint("hello-world");
		List<Logs> logsList = new ArrayList<>();
		logsList.add(log1);
		logSet1.setLogs(logsList);
		logSetList = new ArrayList<>();
		logSetList.add(logSet1);
	}


	private void givenALog() {
		log1 = new Logs();
		log1.setIp("172.0.0.1");
		log1.setTimestamp(dateTime.toDate());
	}


	private void givenADate() {
		dateTime = DateTime.now()
				.withYear(2018)
				.withMonthOfYear(04)
				.withDayOfMonth(1)
				.withHourOfDay(10)
				.withMinuteOfHour(10)
				.withSecondOfMinute(0)
				.withMillisOfSecond(0);
	}
	
}
