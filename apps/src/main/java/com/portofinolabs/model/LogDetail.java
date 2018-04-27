package com.portofinolabs.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("LogDetail")
public class LogDetail implements Serializable{

	private static final long serialVersionUID = -7977686252809363444L;
	
	@Id
	private Integer id;
	
	private List<LogSet> logset;

	public List<LogSet> getLogset() {
		return logset;
	}

	public void setLogset(List<LogSet> logset) {
		this.logset = logset;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((logset == null) ? 0 : logset.hashCode());
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
		LogDetail other = (LogDetail) obj;
		if (logset == null) {
			if (other.logset != null)
				return false;
		} else if (!logset.equals(other.logset))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LogDetail [logset=" + logset + "]";
	}

}
