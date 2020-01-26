package com.speedy.repositories;

import javax.transaction.Transactional;

import com.speedy.domain.Student;

@Transactional
public interface StudentRepository extends UserRepository<Student> {

}
