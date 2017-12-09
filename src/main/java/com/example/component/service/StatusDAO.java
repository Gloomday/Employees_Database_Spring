package com.example.component.service;

import java.util.Collection;

import com.example.component.entity.Status;
import com.example.component.interfaces.IStatusService;

/**
 * @author alex
 * class create for use different SQL query
 *
 */
public class StatusDAO implements IStatusService{

	@Override
	public Status searchById(int id) {
	
		return null;
	}

	@Override
	public void updateStatus(Status status) {
	
	}

	@Override
	public void createStatus(Status status) {
		
	}

	@Override
	public void removeStatus(int id) {
			
	}

	@Override
	public Collection<Status> informationAboutStatus(int page) {
		
		return null;
	}

	@Override
	public Collection<Status> informationAboutFullStatus() {
		
		return null;
	}

}
