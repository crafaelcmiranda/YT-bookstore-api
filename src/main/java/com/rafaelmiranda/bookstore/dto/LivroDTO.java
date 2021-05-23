package com.rafaelmiranda.bookstore.dto;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.rafaelmiranda.bookstore.domain.Livro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor
public class LivroDTO {
	
	private Integer id;
	@NotEmpty(message = "Campo TITULO não pode ser vazio")
	@Length(min = 3,max = 100, message = "Campo TITULO deve ter entre 3 e 100 caracteres" )
	private String titulo;

	@NotEmpty(message = "Campo NOME AUTOR não pode ser vazio")
	@Length(min = 3,max = 100, message = "Campo NOME AUTOR deve ter entre 3 e 100 caracteres" )
	private String nomeAutor;

	@NotEmpty(message = "Campo TEXTO não pode ser vazio")
	@Length(min = 3,max = 100, message = "Campo TEXTO deve ter entre 3 e 100 caracteres" )
	private String texto;
	
	public LivroDTO(Livro livro) {
		super();
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
		this.texto = livro.getTexto();
		this.nomeAutor = livro.getNomeAutor();
	}

}
