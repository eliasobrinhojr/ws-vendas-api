package br.com.icts.flex.wsvendasapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "PARAMETER")
public class Parameter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "estoque")
	private Long estoque;

	@NotNull(message = "tipo não pode ser nulo")
	@Column(name = "tipo")
	private String tipo;

	@Column(name = "minimo")
	private String minimo;

	@Column(name = "maximo")
	private String maximo;
	
	
}
