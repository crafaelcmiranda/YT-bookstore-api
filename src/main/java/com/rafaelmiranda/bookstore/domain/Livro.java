package com.rafaelmiranda.bookstore.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
@Entity
public class Livro implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria = new Categoria();

	public Livro(Integer id, String titulo, String nomeAutor, String texto, Categoria categoria) {
		super();
		this.titulo = titulo;
		this.nomeAutor = nomeAutor;
		this.texto = texto;
		this.categoria = categoria;
	}
}
