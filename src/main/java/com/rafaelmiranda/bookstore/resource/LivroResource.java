package com.rafaelmiranda.bookstore.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rafaelmiranda.bookstore.domain.Livro;
import com.rafaelmiranda.bookstore.dto.LivroDTO;
import com.rafaelmiranda.bookstore.service.LivroService;

import javassist.tools.rmi.ObjectNotFoundException;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/livros")//localhost:8080/categorias/1
public class LivroResource {
	
	@Autowired
	private LivroService service;
	
	@PostMapping
	public ResponseEntity<Livro> create(@Valid @RequestParam(value = "categoria",defaultValue = "0") Integer idCat,@RequestBody Livro obj){
		obj.getCategoria().setId(idCat);
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PostMapping(value = "/{id}")
	public ResponseEntity<Livro> update(@PathVariable Integer id,@Valid @RequestBody Livro obj){
		//Livro objlivro = service.findById(id);
		//service.
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Livro> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Livro> findById(@PathVariable Integer id) throws ObjectNotFoundException{
		Livro livro = service.findById(id);
		return ResponseEntity.ok().body(livro);
	}
	
	@GetMapping()
	public ResponseEntity<List<LivroDTO>> findAllByCategoria(@RequestParam(value = "categoria",defaultValue = "0") Integer idCat){
		//localhost:8080/livros?categoria=1
		List<Livro> livros = service.findAllByCategoria(idCat);
		List<LivroDTO> livroDtos = livros.stream().map(livro -> new LivroDTO(livro)).collect(Collectors.toList());
		return ResponseEntity.ok().body(livroDtos);
	}

	/*
	@GetMapping()
	public ResponseEntity<List<LivroDTO>> findAll() {
		List<Livro> livros = service.findAll();
		List<LivroDTO> livroDtos = livros.stream().map(livro -> new LivroDTO(livro)).collect(Collectors.toList());
		return ResponseEntity.ok().body(livroDtos); 
		}
	 */
	
	
}
