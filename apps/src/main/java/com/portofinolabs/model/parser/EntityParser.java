package com.portofinolabs.model.parser;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;

@Component
public class EntityParser <T>{

	public String parse(T detail) {
		return new Gson().toJson(detail);
	}
	
}
