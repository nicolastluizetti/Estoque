package Estoque.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
	
	@ManyToOne
	@JoinColumn(name="categoria_pai_id")
	private Categoria categoriaPai;
	
	@OneToMany(mappedBy = "categoriaPai")
	private List<Categoria> categorias;
	
	

}
