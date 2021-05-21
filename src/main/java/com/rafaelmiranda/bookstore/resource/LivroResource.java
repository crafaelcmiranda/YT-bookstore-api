package com.rafaelmiranda.bookstore.resource;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafaelmiranda.bookstore.domain.Livro;
import com.rafaelmiranda.bookstore.repository.LivroRepository;

@Service
public class LivroResource {
	
	@Autowired
	private LivroRepository livroRepository;
	
	public Livro findById(Integer id) {
		Optional<Livro> obj = livroRepository.findById(id);
		return obj.orElse(null);
	}
}
