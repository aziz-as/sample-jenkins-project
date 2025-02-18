package com.project.simple_student_details_project_with_mysql_db.service;

import com.project.simple_student_details_project_with_mysql_db.dto.StudentDTO;

public interface StudentService {

	StudentDTO addStudent(StudentDTO request);

	StudentDTO addStudentWithLogic(StudentDTO request);

	StudentDTO getStudentById(Long id);

	StudentDTO updateStudentNameById(Long id, String name);

	boolean deleteStudentById(Long id);

	StudentDTO updateStudentNameByIdUsingPostMapping(Long id, StudentDTO request);

}
