package com.project.simple_student_details_project_with_mysql_db.dto;

public class StudentResponse {

	private String message;
	private boolean status;
	private StudentDTO data;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public StudentDTO getData() {
		return data;
	}
	public void setData(StudentDTO data) {
		this.data = data;
	}	
}
