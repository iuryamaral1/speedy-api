package com.speedy.domain;

import java.util.List;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;

@Entity
@Table(name = "school_hours")
@SequenceGenerator(name = "school_hours_seq", sequenceName = "school_hours_seq")
public class SchoolHours {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "school_hours_seq")
	private Long id;
	
	//disciplina
	@OneToMany
	private List<Subject> subjects;
}
