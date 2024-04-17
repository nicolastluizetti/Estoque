package Estoque.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name="Nota Fiscal")
public class NotaFiscal {

	@EqualsAndHashCode.Include
	@Id
	private Integer id;
	
	@Column(name="pedido_id")
	private Integer pedidoID;
	
	@Column(name="data_emissao")
	private Date data;
}
