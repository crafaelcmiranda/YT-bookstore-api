package com.rafaelmiranda.bookstore.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
@Entity
public class Categoria implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "Campo NOME não pode ser vazio")
	@Length(min = 3,max = 100, message = "Campo NOME deve ter entre 3 e 100 caracteres" )
	private String nome;
	
	@NotEmpty(message = "Campo DESCRIÇÃO não pode ser vazio")
	@Length(min = 3,max = 200, message = "Campo DESCRIÇÃO deve ter entre 3 e 200 caracteres" )
	private String descricao;
	
	
	@OneToMany(mappedBy = "categoria")
	private List<Livro> livros = new ArrayList<Livro>();

	public Categoria(Integer id, String nome, String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}
	
}
