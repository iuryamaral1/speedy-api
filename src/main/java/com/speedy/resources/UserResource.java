package com.speedy.resources;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.speedy.domain.User;
import com.speedy.repositories.UserRepository;

@RestController
@RequestMapping("/users")
public class UserResource {

	@Autowired
	private UserRepository<User> userRepository;

	@GetMapping
	public List<User> findAll() {
		return (List<User>) this.userRepository.findAll();
	}

	@GetMapping("/{username}")
	@RolesAllowed("ROLE_USER")
	public ResponseEntity<User> findByUsername(@PathVariable("username") String username) {

		if (username == null || username.isEmpty()) {
			return ResponseEntity.badRequest().build();
		}

		User user = this.userRepository.findByUsername(username);
		user.setPassword(null);
		return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
	}
	
	@PutMapping
	public ResponseEntity<User> updateUser(@Valid @RequestBody User user) {

		if (user == null) {
			return ResponseEntity.badRequest().build();
		}

		User updatedUser = this.userRepository.save(user);
		return ResponseEntity.ok(updatedUser);
	}

}
