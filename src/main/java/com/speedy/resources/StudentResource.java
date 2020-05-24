package com.speedy.resources;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.speedy.domain.Student;
import com.speedy.repositories.StudentRepository;

@RestController
@RequestMapping("/students")
public class StudentResource {

	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping
	public List<Student> findAll() {
		return (List<Student>) ResponseEntity.ok(this.studentRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Student> findById(@PathVariable("id") Long id) {
		try {
			return ResponseEntity.ok(this.studentRepository.findById(id).get());
		} catch (Exception e) {
			return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PostMapping
	public ResponseEntity<Student> createStudent(@Valid @RequestBody Student student) {
		try {
			student.generateRegistrationNumber();
			return ResponseEntity.ok(this.studentRepository.save(student));
		} catch (Exception e) {
			return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping
	public ResponseEntity<Student> updateStudent(@Valid @RequestBody Student student) {
		try {
			return ResponseEntity.ok(this.studentRepository.save(student));
		} catch (Exception e) {
			return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity deleteStudent(@PathVariable("id") Long id) {
		try {
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
		}
	}
}
