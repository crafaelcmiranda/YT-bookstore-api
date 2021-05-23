package com.rafaelmiranda.bookstore.dto;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.rafaelmiranda.bookstore.domain.Categoria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor
public class CategoriaDTO {
	
	private Integer id;
	@NotEmpty(message = "Campo NOME não pode ser vazio")
	@Length(min = 3,max = 100, message = "Campo NOME deve ter entre 3 e 100 caracteres" )
	private String nome;
	
	@NotEmpty(message = "Campo DESCRIÇÃO não pode ser vazio")
	@Length(min = 3,max = 200, message = "Campo DESCRIÇÃO deve ter entre 3 e 200 caracteres" )
	private String descricao;
	
	public CategoriaDTO(Categoria categoria) {
		super();
		this.id = categoria.getId();
		this.nome = categoria.getNome();
		this.descricao = categoria.getDescricao();
	}

}
