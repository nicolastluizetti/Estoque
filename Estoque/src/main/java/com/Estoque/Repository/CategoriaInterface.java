package com.Estoque.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Estoque.Model.Categoria;

public interface CategoriaInterface extends JpaRepository<Categoria, Long>{

}
