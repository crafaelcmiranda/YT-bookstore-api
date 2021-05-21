package com.rafaelmiranda.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafaelmiranda.bookstore.domain.Categoria;
import com.rafaelmiranda.bookstore.domain.Livro;
import com.rafaelmiranda.bookstore.repository.CategoriaRepository;
import com.rafaelmiranda.bookstore.repository.LivroRepository;

@Service
public class DBService {
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private LivroRepository livroRepository;
	
	public void instanciaDeDados() {
		Categoria cat1 = new Categoria(null, "Informática 1", "Livro de TI");
		Categoria cat2 = new Categoria(null, "Informática 2", "Livro de TI");
		Categoria cat3 = new Categoria(null, "Informática 3", "Livro de TI");
		
		
		Livro l1 = new Livro(null, "Clean Code 1", "Rafael", "Texto do Livro",cat1);
		Livro l2 = new Livro(null, "Clean Code 2", "Rafael", "Texto do Livro",cat2);
		Livro l3 = new Livro(null, "Clean Code 3", "Rafael", "Texto do Livro",cat3);
		Livro l4 = new Livro(null, "Clean Code 4", "Rafael", "Texto do Livro",cat3);
		Livro l5 = new Livro(null, "Clean Code 5", "Rafael", "Texto do Livro",cat1);
		
		
		cat1.getLivros().addAll(Arrays.asList(l1,l5));
		cat2.getLivros().addAll(Arrays.asList(l2));
		cat3.getLivros().addAll(Arrays.asList(l3,l4));
		
		//Save
		this.categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		this.livroRepository.saveAll(Arrays.asList(l1,l2,l3,l4,l5));
	}
	
}
