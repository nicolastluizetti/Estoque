package Estoque.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name="Item Pedido")
public class ItemPedido {
	
	@EqualsAndHashCode.Include
	@Id
	public Integer id;
	
	@Column(name="pedido_id")
	private Integer pedidoId;
	
	@Column(name="produto_id")
	private Integer produtoId;
	
	@Column(name="preco_produto")
	private BigDecimal precoProduto;
	
	private Integer quantidade;
	
	

}
