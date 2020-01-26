package com.speedy.domain;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.TemporalType.DATE;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.speedy.constraints.Phone;

@Entity
@Table(name = "student")
@PrimaryKeyJoinColumn(name = "student_id")
public class Student extends User {

	private static final long serialVersionUID = -4877202754073359373L;

	@ManyToOne(fetch = FetchType.LAZY)
	private StudentClass studentClass;
	
	@NotNull
	@OneToOne
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
	
	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name = "registration_number", unique = true, nullable = false, updatable = false)
	private String registrationNumber;

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

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	
	public void generateRegistrationNumber() {
		setRegistrationNumber(UUID.randomUUID().toString());
	}
}