package com.project.simple_student_details_project_with_mysql_db.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.simple_student_details_project_with_mysql_db.entity.Department;

/*
 * @Repository: This is used to define interface as repository extending JpaRepository class
 * 
 * To make use of the pre-defined classes to store and retrieve data and make use of database
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

	Optional<Department> findByName(String name);

}
