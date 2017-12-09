package com.example.component.service;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.component.entity.Record;
import com.example.component.entity.ReturnedStatus;
import com.example.component.entity.Status;


/**
 * 
 * @author alex
 * This class created for use different SQL query
 *
 */
@Repository
public class RecordDAO {//implements IRecordService{
	static final String SQL_FOR_SEARCH = "SELECT id, employees.last_name, employees.first_name, employees.middle_name, status.name "
			+ "FROM employees JOIN status ON "
			+ "employees.status_id = status.id WHERE id=?";
	static final String SQL_FOR_UPDATE = "UPDATE employees SET last_name=?, first_name=?, middle_name=? WHERE id=?";
	static final String SQL_FOR_SHOWALL = "SELECT * FROM employees LIMIT 3 offset ?";
	static final String SQL_FOR_CREATE = "INSERT INTO employees (last_name, first_name, middle_name, status_id) VALUES (?, ?, ?, ?)";
	static final String SQL_FOR_REMOVE = "DELETE FROM employees WHERE id=?";
	
	
	ReturnedStatus returnedStatus = new ReturnedStatus();
	static final String RESULT_SUCCESS = "SUCCESS";
	static final String RESULT_ERROR = "ERROR";
	
	@Autowired
	private JdbcTemplate jdbc;
	
	public static class NewRecord implements RowMapper<Record>
	{
		@Override
		public Record mapRow(ResultSet rs, int rowNum) throws SQLException {
			Record record = new Record();
			record.setId(rs.getInt(1));
			record.setLastName(rs.getString(2));
			record.setFirstName(rs.getString(3));
			record.setMiddleName(rs.getString(4));
			
			return record;
		}
	}
	
	public static class NewStatus implements RowMapper<Status>{

		@Override
		public Status mapRow(ResultSet rs, int rowNum) throws SQLException {
			Status status = new Status();
			status.setId(rs.getInt(1));
			status.setName(rs.getString(2));
			return status;
		}		
	}
	
	/**
	 * method for search all over the record in database by id
	 * @param id
	 * @return record
	 */

	public Record searchById(int id) {
		Record record = jdbc.queryForObject(SQL_FOR_SEARCH, new NewRecord(), id);
		return record;
	}

	/**
	 * method for update date in database 
	 *@param record
	 */
	
	public void updateRecord(Record record) {
		jdbc.update(SQL_FOR_UPDATE, record.getLastName(), record.getFirstName(), record.getMiddleName(), record.getId());
	}
	/**
	 * method for show all records on page in database via List
	 * @param page
	 * @return record
	 */

	public Collection<Record> informationAboutRecord(int page) {
		page *=3;
		List<Record> record = jdbc.query(SQL_FOR_SHOWALL, new NewRecord(), page);
		return record;
	}
	
	/**
	 * method for create record and write in database 
	 * @param record
	 */
	
	public void createRecord(Record record) {
		jdbc.update(SQL_FOR_CREATE, record.getLastName(), record.getFirstName(), record.getMiddleName());
	}

	/**
	 *method for remove record in database by id 
	 *@param id
	 */
	
	public void removeRecord(int id) {
		jdbc.update(SQL_FOR_REMOVE, id);
	}

}
