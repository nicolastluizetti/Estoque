package com.Estoque.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Estoque.Model.Produto;
import com.Estoque.Service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	

	    @Autowired
	    private ProdutoService produtoService;

	    // 1. Criar um Produto
	    @PostMapping
	    public ResponseEntity<Produto> criarProduto(@RequestBody Produto produto) {
	        Produto novoProduto = produtoService.Criarproduto(produto);
	        return ResponseEntity.status(HttpStatus.CREATED).body(novoProduto);
	    }

	    // 2. Buscar Produto por ID
	    @GetMapping("/{id}")
	    public ResponseEntity<Optional<Produto>> buscarProdutoPorId(@PathVariable Long id) {
	        Optional<Produto> produto = produtoService.achar(id);
	        return ResponseEntity.ok(produto);
	    }

	    // 3. Listar Todos os Produtos
	    @GetMapping
	    public ResponseEntity<List<Produto>> listarTodosProdutos() {
	        List<Produto> produtos = produtoService.listar();
	        return ResponseEntity.ok(produtos);
	    }

	   

	    // 5. Deletar Produto
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
	        produtoService.DeletarProduto(id);
	        return ResponseEntity.noContent().build();
	    }

	    // 6. Listar Produtos com Estoque Baixo
	    @GetMapping("/estoque-baixo/{limite}")
	    public ResponseEntity<List<Produto>> listarProdutosComEstoqueBaixo(@PathVariable int limite) {
	        List<Produto> produtos = produtoService.listarProdutosComEstoqueBaixo(limite);
	        return ResponseEntity.ok(produtos);
	    }

	    // 7. Registrar Movimentação de Estoque
	    @PostMapping("/{id}/movimentacao")
	    public ResponseEntity<Produto> registrarMovimentacao(
	        @PathVariable Long id,
	        @RequestParam int quantidade,
	        @RequestParam String tipo
	    ) {
	        Produto produto = produtoService.registrarMovimentacao(id, quantidade, tipo);
	        return ResponseEntity.ok(produto);
	    }

	    // 8. Listar Produtos por Categoria
	    @GetMapping("/categoria/{categoriaId}")
	    public ResponseEntity<List<Produto>> listarPorCategoria(@PathVariable Long categoriaId) {
	        List<Produto> produtos = produtoService.listar();
	        return ResponseEntity.ok(produtos);
	    }
	}


