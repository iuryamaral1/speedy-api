package com.speedy.repositories;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.speedy.domain.User;

@Repository
public interface UserRepository<T extends User> extends CrudRepository<T, Serializable> {

	Optional<T> findByEmail(String email);

    Optional<T> findByUsernameOrEmail(String username, String email);

    List<T> findByIdIn(List<Long> userIds);

    T findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

	Optional<T> findById(Long id);
}
