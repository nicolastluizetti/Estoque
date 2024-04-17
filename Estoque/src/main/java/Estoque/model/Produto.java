package Estoque.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name="Produto")
public class Produto {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	public Integer id;
	
	public String nome;
	
	public String descricao;
	
	public BigDecimal preco;
	
	public BigDecimal quantidade;
	
	public String unidade;
	
	
}
