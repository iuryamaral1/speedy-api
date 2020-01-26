package com.speedy.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "uf")
@SequenceGenerator(name = "uf_seq", sequenceName = "uf_seq")
public class Uf {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "uf_seq")
	private Long id;
	
	//sigla
	@Size(min = 2, max = 2)
	@NotNull
	@NotEmpty
	@NotBlank
	@Column(name = "abbreviation", nullable = false, unique = true)
	private String abbreviation;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
}
