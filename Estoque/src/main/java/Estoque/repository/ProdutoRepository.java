package Estoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Estoque.model.Produto;



public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
