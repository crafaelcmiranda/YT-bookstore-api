package com.rafaelmiranda.bookstore.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor 
@EqualsAndHashCode
public class Livro {

	@Getter private Integer id;
	@Getter @Setter	private String titulo;
	@Getter @Setter	private String nomeAutor;
	@Getter @Setter	private String texto;

	@Getter @Setter	private Categoria categoria;

	public Livro(String titulo, String nomeAutor, String texto, Categoria categoria) {
		super();
		this.titulo = titulo;
		this.nomeAutor = nomeAutor;
		this.texto = texto;
		this.categoria = categoria;
	}
}
