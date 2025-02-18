package com.project.simple_student_details_project_with_mysql_db.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.simple_student_details_project_with_mysql_db.dto.DepartmentDTO;
import com.project.simple_student_details_project_with_mysql_db.dto.StudentDTO;
import com.project.simple_student_details_project_with_mysql_db.dto.SubjectDTO;
import com.project.simple_student_details_project_with_mysql_db.entity.Department;
import com.project.simple_student_details_project_with_mysql_db.entity.Student;
import com.project.simple_student_details_project_with_mysql_db.entity.Subject;
import com.project.simple_student_details_project_with_mysql_db.repository.DepartmentRepository;
import com.project.simple_student_details_project_with_mysql_db.repository.StudentRepository;
import com.project.simple_student_details_project_with_mysql_db.repository.SubjectRepository;
import com.project.simple_student_details_project_with_mysql_db.service.StudentService;

/*
 * @Service: This is used to define the class as the service class
 */
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private SubjectRepository subjectRepository;

	@Override
	public StudentDTO addStudent(StudentDTO request) {
		Student student = parseToStudent(request);
		try {
			studentRepository.save(student);

			return parseToStudentDTO(student);
		}
		catch(Exception ex){
			return null;
		}

	}

	/*
	 * This is a utility class we have created to avoid manual work 
	 * everytime we need to do some operations
	 * 
	 * This is used to parseToStudentDTO()
	 */
	private StudentDTO parseToStudentDTO(Student student) {
		List<SubjectDTO> subjects = new ArrayList<>();

		for(Subject subject: student.getDepartment().getSubjects()) {
			SubjectDTO subjectDto = new SubjectDTO();
			subjectDto.setId(subject.getId());
			subjectDto.setName(subject.getName());
			subjects.add(subjectDto);
		}

		DepartmentDTO departmentDto = new DepartmentDTO();
		departmentDto.setId(student.getDepartment().getId());
		departmentDto.setName(student.getDepartment().getName());
		departmentDto.setSubjects(subjects);

		StudentDTO studentDto = new StudentDTO();
		studentDto.setId(student.getId());
		studentDto.setName(student.getName());
		studentDto.setRollNo(student.getRollNo());
		studentDto.setDepartment(departmentDto);

		return studentDto;
	}

	/*
	 * This is a utility class we have created to avoid manual work 
	 * everytime we need to do some operations
	 * 
	 * This is used to parseToStudent()
	 */
	private Student parseToStudent(StudentDTO request) {
		Student student = new Student();

		student.setName(request.getName());
		student.setRollNo(request.getRollNo());

		Department department = new Department();
		department.setName(request.getDepartment().getName());

		List<Subject> subjects = new ArrayList<>() ;

		for(SubjectDTO subjectDTO: request.getDepartment().getSubjects()) {
			Subject subject = new Subject();
			subject.setName(subjectDTO.getName());
			subjects.add(subject);
		}
		department.setSubjects(subjects);
		student.setDepartment(department);
		return student;
	}

	@Override
	public StudentDTO addStudentWithLogic(StudentDTO request) {
		Department department = new Department();
		Student student = new Student();
		List<Subject> subjects = new ArrayList<>();

		Optional<Student> studentOp = studentRepository.findByRollNo(request.getRollNo());
		if(studentOp.isEmpty()) {
			Optional<Department> departmentOp = departmentRepository.findByName(request.getDepartment().getName());
			if(departmentOp.isEmpty()) {
				for(SubjectDTO subjectDto: request.getDepartment().getSubjects()) {
					Optional<Subject> subjectOp = subjectRepository.findByName(subjectDto.getName());
					if(subjectOp.isEmpty()) {
						Subject subject = new Subject();
						subject.setName(subjectDto.getName());
						subjects.add(subject);
					}
				}
				department.setName(request.getDepartment().getName());
				department.setSubjects(subjects);
			}else {
				for(SubjectDTO subjectDto: request.getDepartment().getSubjects()) {
					Optional<Subject> subjectOp = subjectRepository.findByName(subjectDto.getName());
					if(subjectOp.isEmpty()) {
						Subject subject = new Subject();
						subject.setName(subjectDto.getName());
						subjects.add(subject);
					}
				}
				department = departmentOp.get();
				subjects.addAll(department.getSubjects());	
				department.setSubjects(subjects);
			}
			student.setName(request.getName());
			student.setRollNo(request.getRollNo());
			student.setDepartment(department);
			studentRepository.save(student);
		}else {
			Optional<Department> departmentOp = departmentRepository.findByName(request.getDepartment().getName());
			if(departmentOp.isEmpty()) {
				for(SubjectDTO subjectDto: request.getDepartment().getSubjects()) {
					Optional<Subject> subjectOp = subjectRepository.findByName(subjectDto.getName());
					if(subjectOp.isEmpty()) {
						Subject subject = new Subject();
						subject.setName(subjectDto.getName());
						subjects.add(subject);
					}
				}
				department.setName(request.getDepartment().getName());
				department.setSubjects(subjects);
			}else {
				for(SubjectDTO subjectDto: request.getDepartment().getSubjects()) {
					Optional<Subject> subjectOp = subjectRepository.findByName(subjectDto.getName());
					if(subjectOp.isEmpty()) {
						Subject subject = new Subject();
						subject.setName(subjectDto.getName());
						subjects.add(subject);
					}
				}
				department = departmentOp.get();
				subjects.addAll(department.getSubjects());
				department.setSubjects(subjects);
			}
			student = studentOp.get();
			student.setDepartment(department);
			studentRepository.save(student);
		}
		return parseToStudentDTO(student);
	}

	@Override
	public StudentDTO getStudentById(Long id) {
		Optional<Student> studentOp = studentRepository.findById(id);

		if(studentOp.isPresent()) {
			return parseToStudentDTO(studentOp.get());
		}else {
			return null;
		}
	}

	@Override
	public StudentDTO updateStudentNameById(Long id, String name) {
		Optional<Student> studentOp = studentRepository.findById(id);

		if(studentOp.isPresent()) {
			Student student = new Student();
			student = studentOp.get();
			student.setName(name);
			studentRepository.save(student);
			return parseToStudentDTO(student);
		}else {
			return null;
		}
	}

	@Override
	public boolean deleteStudentById(Long id) {
		Optional<Student> studentOp = studentRepository.findById(id);

		if(studentOp.isPresent()) {
			studentRepository.deleteById(id);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public StudentDTO updateStudentNameByIdUsingPostMapping(Long id, StudentDTO request) {
		Optional<Student> studentOp = studentRepository.findById(id);

		if(studentOp.isPresent()) {
			Student student = new Student();
			student = studentOp.get();
			student.setName(request.getName());
			studentRepository.save(student);
			return parseToStudentDTO(student);
		}else {
			return null;
		}
	}
}

