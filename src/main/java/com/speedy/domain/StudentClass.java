package com.speedy.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "studentClass")
@SequenceGenerator(name = "studentClass_seq", sequenceName = "studentClass_seq")
public class StudentClass {

	/* Turma */
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "studentClass_seq")
	private Long id;
	
	@Column(name = "name", nullable = false, unique = true)
	private String name;
	
	@ManyToMany
	private List<Teacher> teachers;
	
	@OneToMany(mappedBy = "studentClass")
	private List<Student> students;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Grade grade;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

}
