package com.project.simple_student_details_project_with_mysql_db.controller;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.simple_student_details_project_with_mysql_db.dto.StudentDTO;
import com.project.simple_student_details_project_with_mysql_db.dto.StudentResponse;
import com.project.simple_student_details_project_with_mysql_db.service.StudentService;

/*
 * @RestController annotation is used to define the class as Controller Class 
 * with All the Mappings of API endpoints
 * 
 */
@RestController
public class StudentController {

	/*
	 * @Autowired: This annotation is used to define beans and recognize components
	 * such as @Sevice 
	 */
	@Autowired
	private StudentService studentService;
	
	

	/*
	 * @GetMapping: This annotation is used for defining Get API Call and it's endpoint.
	 */
	@GetMapping("/test")
	public ResponseEntity<String> test(){
		return new ResponseEntity<>("Success",HttpStatus.OK);
	}
	

	/*
	 * @PostMapping: This annotation is used for defining Post API Call and it's endpoint.
	 * 
	 * This also requires a response and request to be used. Response can be null
	 */
	@PostMapping("/add-student")
	public ResponseEntity<StudentResponse> addStudent(@RequestBody StudentDTO request){
		StudentDTO data = studentService.addStudent(request);
		
		StudentResponse response = new StudentResponse();
		if(Objects.isNull(data)) {
			response.setMessage("Data was not added");
			response.setStatus(true);
			response.setData(data);
		}
		else {
			response.setMessage("Data Successfully Added");
			response.setStatus(true);
			response.setData(data);
		}
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	/*
	 * @PostMapping: This annotation is used for defining Post API Call and it's endpoint.
	 * 
	 * This also requires a response and request to be used. Response can be null
	 */
	@PostMapping("/add-student-logic")
	public ResponseEntity<StudentResponse> addStudentWithLogic(@RequestBody StudentDTO request){
		StudentDTO data = studentService.addStudentWithLogic(request);
		
		StudentResponse response = new StudentResponse();
		if(Objects.isNull(data)) {
			response.setMessage("Data was not added");
			response.setStatus(true);
			response.setData(data);
		}
		else {
			response.setMessage("Data Successfully Added");
			response.setStatus(true);
			response.setData(data);
		}
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	/*
	 * @GetMapping: This annotation is used for defining Get API Call and it's endpoint.
	 * 
	 * This API is being used to get all the records
	 */
	@GetMapping("/get-student/{id}")
	public ResponseEntity<StudentResponse> getStudentById(@PathVariable("id")Long id){
		StudentDTO data = studentService.getStudentById(id); 
		
		StudentResponse response = new StudentResponse();
		if(Objects.isNull(data)) {
			response.setMessage("Data Not Found");
			response.setStatus(true);
			response.setData(data);
		}
		else {
			response.setMessage("Data Found");
			response.setStatus(true);
			response.setData(data);
		}
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	/*
	 * @PutMapping: This annotation is used for defining Put API Call and it's endpoint.
	 * 
	 * This API is used to update the details of existing record.
	 * This also requires a response and request to be used. Response can be null
	 */
	@PutMapping("/update-student/{id}")
	public ResponseEntity<StudentResponse> updateStudentNameById(@PathVariable Long id,String name){
		StudentDTO data = studentService.updateStudentNameById(id,name);
		StudentResponse response = new StudentResponse();
		if(Objects.isNull(data)) {
			response.setMessage("Data Not Found");
			response.setStatus(true);
			response.setData(data);
		}
		else {
			response.setMessage("Data Found");
			response.setStatus(true);
			response.setData(data);
		}
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	
	/*
	 * @DeleteMapping: This is used to delete the data based on the id provided in url.
	 * 
	 * This can be modified based on the need.
	 */
	@DeleteMapping("/delete-student/{id}")
	public ResponseEntity<String> deleteStudentById(@PathVariable("id") Long id){
		boolean deleted = studentService.deleteStudentById(id);
		if(deleted) {
			return new ResponseEntity<String>("Deleted Data Successfully",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("Data Not Found",HttpStatus.OK);
		}
	}
	
	/*
	 * Note: We can also use @PostMapping to retrieve data same as @GetMapping
	 */
	@PostMapping("/update-student-post/{id}")
	public ResponseEntity<StudentResponse> updateStudentNameByIdUsingPostMapping(@PathVariable Long id,@RequestBody StudentDTO request){
		StudentDTO data = studentService.updateStudentNameByIdUsingPostMapping(id,request);
		StudentResponse response = new StudentResponse();
		if(Objects.isNull(data)) {
			response.setMessage("Data Not Found");
			response.setStatus(true);
			response.setData(data);
		}
		else {
			response.setMessage("Data Found");
			response.setStatus(true);
			response.setData(data);
		}
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
}
