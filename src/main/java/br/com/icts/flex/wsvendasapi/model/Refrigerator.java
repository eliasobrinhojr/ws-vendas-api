package br.com.icts.flex.wsvendasapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "REFRIGERATOR")
public class Refrigerator {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull(message = "Nome não pode ser nulo")
	@Column(name = "nome")
	private String nome;

	@Column(name = "marca")
	private String marca;

	@Column(name = "tipo")
	private String tipo;
	
	@Column(name = "capacidade")
	private String capacidade;
	
	@Column(name = "latitude")
	private String latitude;
	
	@Column(name = "longitude")
	private String longitude;
	
}
