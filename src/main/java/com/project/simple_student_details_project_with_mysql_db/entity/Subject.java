package com.project.simple_student_details_project_with_mysql_db.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/*
 * @Entity: It is used to define the table in database
 */
@Entity
public class Subject {

	/*
	 * @Id: It is used to define the primary key of the table
	 */
	/*
	 * @GeneratedValue: This is used to define some generators and strategies
	 * to auto increment the values.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
