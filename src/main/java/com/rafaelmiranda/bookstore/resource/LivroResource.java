package com.rafaelmiranda.bookstore.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rafaelmiranda.bookstore.domain.Livro;
import com.rafaelmiranda.bookstore.domain.Livro;
import com.rafaelmiranda.bookstore.dto.LivroDTO;
import com.rafaelmiranda.bookstore.repository.LivroRepository;
import com.rafaelmiranda.bookstore.service.LivroService;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class LivroResource {
	
	@Autowired
	private LivroService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Livro> findById(@PathVariable Integer id) throws ObjectNotFoundException{
		Livro categoria = service.findById(id);
		return ResponseEntity.ok().body(categoria);
	}
	
	@GetMapping()
	public ResponseEntity<List<LivroDTO>> findAll(){
		List<Livro> categorias = service.findAll();
		List<LivroDTO> categoriaDtos = categorias.stream().map(categoria -> new LivroDTO(categoria)).collect(Collectors.toList());
		return ResponseEntity.ok().body(categoriaDtos);
	}
	
	@PostMapping
	public ResponseEntity<Livro> create(@RequestBody Livro obj){
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PostMapping(value = "/{id}")
	public ResponseEntity<Livro> update(@PathVariable Integer id,@RequestBody Livro obj){
		Livro objcategoria = service.findById(id);
		//service.
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Livro> update(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
