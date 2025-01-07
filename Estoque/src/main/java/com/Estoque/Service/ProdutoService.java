package com.Estoque.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.Estoque.Model.Produto;
import com.Estoque.Repository.Produtointerface;
import com.Estoque.exception.EntidadeEmUsoException;
import com.Estoque.exception.EntidadeNaoEncontradaException;

public class ProdutoService {
	
	@Autowired
	Produtointerface produtorepository;
	
	public Produto Criarproduto(@RequestBody Produto produto) {
		try {
			return produtorepository.save(produto);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(String.format("Não existe cadastro de produto com  o codigo%d",produto.id));
			
		} 
		catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException((String.format("O produto %d não pode ser removido pois esta em uso",produto.id)));
			
		} 
	} 
	
	public void  DeletarProduto(@PathVariable long id) {
		try {
			produtorepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(String.format("Não existe cadastro de produto com  o codigo%d", id));
			
		} 
		catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException((String.format("O produto %d não pode ser removido pois esta em uso", id)));
			
		} 
		
		 
		
	}
	public Optional<Produto> achar(Long produtoId) {
		try {
			return produtorepository.findById(produtoId);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(String.format("Não existe cadastro de produto com  o codigo%d", produtoId));
		}
	}
	
	public List<Produto> listar(){
		return produtorepository.findAll();
	}
	
	public Produto registrarMovimentacao( Long id, int quantidade, String tipo) {
		Produto objeto = new Produto();

	    if ("ENTRADA".equalsIgnoreCase(tipo)) {
	        objeto.setQuantidade(objeto.getQuantidade()+ quantidade);
	    } else if ("SAIDA".equalsIgnoreCase(tipo)) {
	        if (objeto.getQuantidade() < quantidade) {
	            throw new IllegalArgumentException("Estoque insuficiente!");
	        }
	        objeto.setQuantidade(objeto.getQuantidade() - quantidade);
	    } else {
	        throw new IllegalArgumentException("Tipo de movimentação inválido: " + tipo);
	    }

	    return produtorepository.save(objeto);
	}

	public List<Produto> listarProdutosComEstoqueBaixo(int limite) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
