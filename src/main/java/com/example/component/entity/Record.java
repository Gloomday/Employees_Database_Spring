package com.example.component.entity;

public class Record {
	private int id;
	private String last_name;
	private String first_name;
	private String middle_name;
	private int status_id;
	
	public Record(){}
	
	public Record(int id, String last_name, String first_name, String middle_name, int status_id)
	{
		this.id=id;
		this.last_name = last_name;
		this.first_name = first_name;
		this.middle_name = middle_name;
		this.status_id = status_id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setLastName(String last_name)
	{
		this.last_name = last_name;
	}
	
	public String getLastName()
	{
		return last_name;
	}
	
	public void setFirstName(String first_name)
	{
		this.first_name = first_name;
	}
	
	public String getFirstName()
	{
		return first_name;
	}
	
	public void setMiddleName(String middle_name)
	{
		this.middle_name = middle_name;
	}
	
	public String getMiddleName()
	{
		return middle_name;
	}

	public int getStatus_id() {
		return status_id;
	}

	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}
}
