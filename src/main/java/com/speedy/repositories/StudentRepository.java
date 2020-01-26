package com.speedy.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Long, Serializable> {

}
