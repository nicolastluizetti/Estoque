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
import Estoque.model.Cliente;
import Estoque.repository.ClienteRepository;

@RequestMapping(value = "/cliente")
@RestController
public class ClienteController {
	@Autowired
	public ClienteRepository clienterepository;
	
	@GetMapping
	public List<Cliente> Listar(){
		return clienterepository.findAll();
	}
	
	@GetMapping("/{clienteId}")
	public ResponseEntity<Cliente> buscar(@PathVariable Integer clienteId){
		Optional<Cliente> cliente = clienterepository.findById(clienteId);
		if(cliente.isPresent()) {
			return ResponseEntity.ok(cliente.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public Cliente salvar(@RequestBody Cliente cliente) {
		return clienterepository.save(cliente);
	}
	
	@PutMapping("/{clienteId}")
	public ResponseEntity<Cliente> atualizar(@PathVariable int clienteId, @RequestBody Cliente cliente){
		Optional<Cliente> clienteAtual = clienterepository.findById(clienteId);
		if(clienteAtual.isPresent()) {
			BeanUtils.copyProperties(cliente, clienteAtual,"id");
			
			Cliente clienteSalvo = clienterepository.save(clienteAtual.get());
			return ResponseEntity.ok(clienteSalvo);
		}
		return ResponseEntity.notFound().build();
	}
	
	
	@ResponseStatus(HttpStatus.OK)
	@DeleteMapping("/{clienteId}")
	public void remove(@PathVariable Integer clienteId) {
		try{
			 clienterepository.deleteById(clienteId);
		} catch(EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(String.format("Não existe um cadastro de cliente com o codigo %d", clienteId));
		}catch(DataIntegrityViolationException  e) {
			throw new EntidadeEmUsoException(String.format("O Cliente de codigo: %d, não pode ser removido pois esta em uso", clienteId));
		}
	}
	
	

}
