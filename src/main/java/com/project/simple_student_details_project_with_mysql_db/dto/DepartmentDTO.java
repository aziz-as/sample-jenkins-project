package com.project.simple_student_details_project_with_mysql_db.dto;

import java.util.List;

public class DepartmentDTO {

	private long id;
	private String name;
	private List<SubjectDTO> subjects;
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
	public List<SubjectDTO> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<SubjectDTO> subjects) {
		this.subjects = subjects;
	}

	
	
}
