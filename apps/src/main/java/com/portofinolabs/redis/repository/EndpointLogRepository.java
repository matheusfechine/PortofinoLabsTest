package com.portofinolabs.redis.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.portofinolabs.model.EndpointLog;

@Repository
public interface EndpointLogRepository extends CrudRepository<EndpointLog, String>{

}
