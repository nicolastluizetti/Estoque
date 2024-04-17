package Estoque.model;

import jakarta.persistence.Column;
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
@Table(name="Pagamento Boleto")
public class PagamentoBoleto {
	
	@EqualsAndHashCode.Include
	@Id
	private Integer id;
	
	@Column(name="pedido_id")
	private Integer pedidoId;
	
	@Column(name="codigo_barras")
	@Enumerated(EnumType.STRING)
	private StatusPagamento status;
	
	private String codigobarras;

}
