package com.project.simple_student_details_project_with_mysql_db.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;

/*
 * @Entity: It is used to define the table in database
 */
@Entity
public class Department {

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
	
	
	/*
	 * @OneToMany: This is used for mapping the values 
	 * and it is similar to the joins we perform manually
	 * 
	 * @JoinTable: This is used to define the join table with the details 
	 * of the records with more info such as the IDs it is associated with
	 */
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "dept_subjects_map",
	joinColumns = @JoinColumn(name="department_id"),
	inverseJoinColumns = @JoinColumn(name="subject_id")
			)
	private List<Subject> subjects;
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
	public List<Subject> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	
}
