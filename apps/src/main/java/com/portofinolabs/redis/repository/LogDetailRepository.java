package com.portofinolabs.redis.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.portofinolabs.model.LogDetail;

@Repository
public interface LogDetailRepository extends CrudRepository<LogDetail, String>{

	
	
}
