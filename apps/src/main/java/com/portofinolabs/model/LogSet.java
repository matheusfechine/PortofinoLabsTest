package com.portofinolabs.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("LogSet")
public class LogSet implements Serializable{
	
	private static final long serialVersionUID = 5219343241843427852L;
	
	private String endpoint;
	private List<Logs> logs;

	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	public List<Logs> getLogs() {
		return logs;
	}

	public void setLogs(List<Logs> logs) {
		this.logs = logs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endpoint == null) ? 0 : endpoint.hashCode());
		result = prime * result + ((logs == null) ? 0 : logs.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LogSet other = (LogSet) obj;
		if (endpoint == null) {
			if (other.endpoint != null)
				return false;
		} else if (!endpoint.equals(other.endpoint))
			return false;
		if (logs == null) {
			if (other.logs != null)
				return false;
		} else if (!logs.equals(other.logs))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LogSet [endpoint=" + endpoint + ", logs=" + logs + "]";
	}

}
