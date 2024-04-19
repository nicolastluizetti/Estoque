package Estoque.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name="Pedido")
public class Pedido {
	
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer id;
	
	@ManyToOne
	private Cliente cliente;
	
	@OneToMany
	private List<ItemPedido> itens;
	 
	 
	@Column(name = "pedido_data_criacao")
	private LocalDateTime dataPedido;
	
	@Column(name = "pedido_data_finalizacao")
	private LocalDateTime dataConclusao;
	
	@Column(name = "notafiscal_id")
	private Integer notaFiscalId;
	
	private BigDecimal total;
	
	@Column(name = "status_pedido")
	@Enumerated(EnumType.STRING)
	private StatusPedido status;
	
    @Embedded
    private EnderecoEntregaPedido enderecoEntrega;
	
	

}
