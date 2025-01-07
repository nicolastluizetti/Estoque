package com.Estoque.Model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "movimentacao")
public class movimentacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	@OneToOne
	@JoinColumn(name = "produto_id", nullable = false)
	public Produto produto;
	
	public String tipo;
	
	public Integer quantidade;
	
	public LocalDateTime data;
}
