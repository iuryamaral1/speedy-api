package com.speedy.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "grade")
@SequenceGenerator(name = "grade_seq", sequenceName = "grade_seq")
public class Grade {

	/* Série */
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "grade_seq")
	private Long id;
	
	@ManyToOne
	private List<StudentClass> studentClasses;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<StudentClass> getStudentClasses() {
		return studentClasses;
	}
	public void setStudentClasses(List<StudentClass> studentClasses) {
		this.studentClasses = studentClasses;
	}
}
