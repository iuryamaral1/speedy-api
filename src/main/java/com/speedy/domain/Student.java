package com.speedy.domain;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.TemporalType.DATE;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.speedy.constraints.Phone;

@Entity
@Table(name = "student")
public class Student extends User {

	private static final long serialVersionUID = -4877202754073359373L;

	@OneToMany
	private StudentClass studentClass;
	
	@NotNull
	@Column(name = "school_hours", nullable = false)
	private SchoolHours schoolHours;
	
	@NotNull
	@Enumerated(STRING)
	@Column(name = "genre", nullable = false)
	private Genre genre;
	
	@NotNull
	@Temporal(DATE)
	@Column(name = "birth_date", nullable = false)
	private Date birthDate;
	
	@Phone
	@NotNull
	@NotEmpty
	@NotBlank
	@Column(name = "phone", nullable = false, unique = true)
	private String phone;
	
	@Embedded
	private Address address;
	
	@Column(name = "father_name")
	private String fatherName;
	
	@NotNull
	@NotEmpty
	@NotBlank
	@Column(name = "mother_name", nullable = false)
	private String motherName;

	public StudentClass getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(StudentClass studentClass) {
		this.studentClass = studentClass;
	}

	public SchoolHours getSchoolHours() {
		return schoolHours;
	}

	public void setSchoolHours(SchoolHours schoolHours) {
		this.schoolHours = schoolHours;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
}