package com.speedy.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.speedy.domain.Subject;
import com.speedy.repositories.SubjectRepository;

@RestController
@RequestMapping("/subjects")
public class SubjectResource {

	@Autowired
	private SubjectRepository subjectRepository;
	
	@GetMapping
	public ResponseEntity<List<Subject>> findAll() {
		List<Subject> subjects = this.subjectRepository.findAll();
		return ResponseEntity.ok(subjects);
	}
	
	@PostMapping
	public ResponseEntity<Subject> saveSubject(@Valid @RequestBody Subject subject) {
		Subject savedSubject = this.subjectRepository.saveAndFlush(subject);
		return ResponseEntity.ok(savedSubject);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteSubject(@PathVariable("id") Long id) {
		this.subjectRepository.delete(id);
		return ResponseEntity.ok().build();
	}
}
