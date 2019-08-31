package com.speedy.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.speedy.domain.Categoria;
import com.speedy.repositories.CategoriaRepository;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@GetMapping
	public List<Categoria> listar() {
		return this.categoriaRepository.findAll();
	}

	@PostMapping
	public Categoria salvar(@RequestBody Categoria categoria) {
		return this.categoriaRepository.save(categoria);
	}
	
}
