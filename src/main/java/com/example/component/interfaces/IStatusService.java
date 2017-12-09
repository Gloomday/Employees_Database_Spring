package com.example.component.interfaces;

import java.util.Collection;

import com.example.component.entity.Status;

/**
 * @author alex
 * interface for show method which can use in StatusDAO
 */
public interface IStatusService {
	
	
	/**
	 * method for search all over record in database by id
	 * @param id
	 * @return
	 */
	public Status searchById(int id);
	
	/**method for update record in database  
	 * @param status
	 */
	public void updateStatus(Status status);
	
	/**
	 * method for create record in database
	 * @param status
	 */
	public void createStatus(Status status);
	
	/**
	 * method for remove record in database by id
	 * @param id
	 */
	public void removeStatus(int id);
	
	/**
	 * method for show any records on one page 
	 * @param page
	 * @return
	 */
	public Collection<Status> informationAboutStatus(int page);

	/**
	 * method for show all records in database
	 * @return
	 */
	public Collection<Status> informationAboutFullStatus();
	
}
