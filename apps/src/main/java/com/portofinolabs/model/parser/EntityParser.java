package com.portofinolabs.model.parser;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
/**
 * 
 * This is a Generic Class that parse Objects to Json.
 * 
 * @author matheus
 *
 * @param <T>
 */
@Component
public class EntityParser <T>{

	public String parse(T detail) {
		return new Gson().toJson(detail);
	}
	
}
