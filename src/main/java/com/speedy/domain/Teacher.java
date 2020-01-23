package com.speedy.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "teacher")
@PrimaryKeyJoinColumn(name = "user_id")
@SequenceGenerator(name = "teacher_seq", sequenceName = "teacher_seq")
public class Teacher extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7441616475349470605L;
	
	@OneToMany(mappedBy = "teacher")	
	private List<Subject> subjects;
}
