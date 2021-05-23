package com.rafaelmiranda.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rafaelmiranda.bookstore.domain.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer>{

	@Query("SELECT obj FROM Livro obj WHERE obj.categoria.id = :idCat ORDER BY obj.titulo")
	List<Livro> findAAllByCategoria(@Param(value = "idCat") Integer idCat);

}
