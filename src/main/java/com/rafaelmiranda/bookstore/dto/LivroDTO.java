package com.rafaelmiranda.bookstore.dto;

import com.rafaelmiranda.bookstore.domain.Livro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor
public class LivroDTO {
	
	private Integer id;
	private String titulo;
	private String nomeAutor;
	private String texto;
	
	public LivroDTO(Livro livro) {
		super();
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
		this.texto = livro.getTexto();
		this.nomeAutor = livro.getNomeAutor();
	}

}
