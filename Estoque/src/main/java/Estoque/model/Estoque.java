package Estoque.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name="Estoque")
public class Estoque {
	
	
	@EqualsAndHashCode.Include
	@Id
	public Integer id;
	
	@Column(name="produto_id")
	private Integer produtoId;
	
	private Integer quantidade;
	
	

}
