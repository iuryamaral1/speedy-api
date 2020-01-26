package com.speedy.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.speedy.constraints.Cep;

@Embeddable
public class Address {

	@Cep
	@NotNull
	@Column(name = "cep", nullable = false)
	private String cep;
	
	@NotNull
	@NotEmpty
	@NotBlank
	@Size(max = 150)
	@Column(name = "street_name", nullable = false)
	private String streetName;
	
	@Column(name = "number_house")
	private String number;
	
	@OneToOne
	private City city;
	
	@OneToOne
	private Uf state;
	
	@Column(name = "additional_details")
	private String additionalDetails;

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Uf getState() {
		return state;
	}

	public void setState(Uf state) {
		this.state = state;
	}

	public String getAdditionalDetails() {
		return additionalDetails;
	}

	public void setAdditionalDetails(String additionalDetails) {
		this.additionalDetails = additionalDetails;
	}
}
