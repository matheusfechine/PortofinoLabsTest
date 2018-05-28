package com.portofinolabs.service;

import java.util.Iterator;
import java.util.List;

public class EndpointIterable<T> implements Iterable<T> {

	private List<T> list;
	
	
	
	public EndpointIterable(List<T> list) {
		this.list = list;
	}


	@Override
	public Iterator<T> iterator() {
		return list.iterator();
	}

}
