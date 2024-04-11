package Estoque.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import Estoque.Exception.EntidadeEmUsoException;
import Estoque.Exception.EntidadeNaoEncontradaException;
import Estoque.model.Produto;
import Estoque.repository.ProdutoRepository;



@RequestMapping(value = "/produto")
@RestController
public class ProdutoController {
	
	@Autowired
	public ProdutoRepository produtorepository;
	
	@GetMapping
	public List<Produto> Listar(){
		return produtorepository.findAll();
	}
	
	@GetMapping("/{produtoId}")
	public ResponseEntity<Produto> buscar(@PathVariable Integer produtoId){
		Optional<Produto> produto = produtorepository.findById(produtoId);
		if(produto.isPresent()) {
			return ResponseEntity.ok(produto.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public Produto salvar(@RequestBody Produto produto) {
		return produtorepository.save(produto);
	}
	
	@PutMapping("/{produtoId}")
	public ResponseEntity<Produto> atualizar(@PathVariable int produtoId, @RequestBody Produto produto){
		Optional<Produto> produtoAtual = produtorepository.findById(produtoId);
		if(produtoAtual.isPresent()) {
			BeanUtils.copyProperties(produto, produtoAtual,"id");
			
			Produto produtoSalvo = produtorepository.save(produtoAtual.get());
			return ResponseEntity.ok(produtoSalvo);
		}
		return ResponseEntity.notFound().build();
	}
	
	
	@ResponseStatus(HttpStatus.OK)
	@DeleteMapping("/{produtoId}")
	public void remove(@PathVariable Integer produtoId) {
		try{
			 produtorepository.deleteById(produtoId);
		} catch(EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(String.format("Não existe um cadastro de produto com o codigo %d", produtoId));
		}catch(DataIntegrityViolationException  e) {
			throw new EntidadeEmUsoException(String.format("O Produto de codigo: %d, não pode ser removido pois esta em uso", produtoId));
		}
	}
	
	

}
