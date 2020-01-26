package com.speedy.domain;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "school_principal")
@PrimaryKeyJoinColumn(name = "school_principal_id")
public class SchoolPrincipal extends User {

	
	private static final long serialVersionUID = -3560492787465517734L;

	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name = "name", nullable = false)
	private String name;
	
	@OneToOne(fetch = FetchType.EAGER)
	private School school;
	
	@Embedded
	private Address address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
