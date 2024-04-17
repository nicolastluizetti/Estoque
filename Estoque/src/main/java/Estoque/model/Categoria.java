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
@Table(name="Categoria")
public class Categoria {
	
	
	@EqualsAndHashCode.Include
	@Id
	public Integer id;
	
	private String nome;
	
	@Column(name="categoria_pai_id")
	private Integer categoriaPaiId;
	
	

}
