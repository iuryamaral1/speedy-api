package com.speedy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.speedy.domain.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
	
	public Subject findByName(String name);
}
