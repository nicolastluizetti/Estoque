package com.Estoque.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Estoque.Model.movimentacao;

public interface MovimentacaoInterface extends JpaRepository<movimentacao, Long>{

}
