package com.speedy.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "city")
@SequenceGenerator(name = "city_seq", sequenceName = "city_seq")
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "city_seq")
	private Long id;
	
	@NotNull
	@Size(max = 150)
	@Column(name = "name", nullable = false)
	private String name;
	
	@OneToOne
	private Uf uf;
	
	
	
}
