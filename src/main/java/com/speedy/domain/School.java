package com.speedy.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CNPJ;

@Entity
@Table(name = "school")
@SequenceGenerator(name = "school_seq", sequenceName = "school_seq")
public class School {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "school_seq")
	private Long id;
	
	@NotNull
	@NotBlank
	@NotEmpty
	@Size(min = 1, max = 200)
	@Column(name = "name", nullable = false)
	private String name;
	
	@OneToMany
	private List<Student> students;
	
	@CNPJ
	@NotNull
	@NotEmpty
	@NotBlank
	@Size(max = 14)
	@Column(name = "cnpj", length = 14)
	private String cnpj;
	
	@OneToOne(mappedBy = "school")
	private SchoolPrincipal schoolPrincipal;
	
	@OneToMany
	private List<Teacher> teachers;
	
	@Embedded
	private Address address;
	
	@OneToMany
	private List<Grade> grades;

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

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public SchoolPrincipal getSchoolPrincipal() {
		return schoolPrincipal;
	}

	public void setSchoolPrincipal(SchoolPrincipal schoolPrincipal) {
		this.schoolPrincipal = schoolPrincipal;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Grade> getGrades() {
		return grades;
	}

	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
}
