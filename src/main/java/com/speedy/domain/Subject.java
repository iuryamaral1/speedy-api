package com.speedy.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "subject")
@SequenceGenerator(name = "subject_seq", sequenceName = "subject_seq")
public class Subject {
	
	@Id
	private Long id;
	
	@NotNull
	@Size(max = 50)
	@Column(name = "name", unique = true, nullable = false)
	private String name;
	
	@ManyToOne
	@Column(name = "teacher_id")
	private Teacher teacher;

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

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
}
