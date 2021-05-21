package com.rafaelmiranda.bookstore.dto;

import com.rafaelmiranda.bookstore.domain.Categoria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor
public class CategoriaDTO {
	
	private Integer id;
	private String nome;
	private String descricao;
	
	public CategoriaDTO(Categoria categoria) {
		super();
		this.id = categoria.getId();
		this.nome = categoria.getNome();
		this.descricao = categoria.getDescricao();
	}

}
