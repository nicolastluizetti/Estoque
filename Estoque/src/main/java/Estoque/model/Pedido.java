package Estoque.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
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
	public Integer id;
	
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
