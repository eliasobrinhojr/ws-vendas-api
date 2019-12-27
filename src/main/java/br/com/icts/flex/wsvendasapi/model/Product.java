package br.com.icts.flex.wsvendasapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "PRODUCT")
public class Product implements Serializable {

	private static final long serialVersionUID = -4513299829436850638L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull(message = "Código não pode ser nulo")
	@Column(name = "codigo")
	private String codigo;

	@NotNull(message = "Estoque nulo ou inválido")
	@Min(value = 0, message = "Estoque não pode ser menor que 0")
	@Column(name = "estoque")
	private Long estoque;

	@NotNull(message = "Nome não pode ser nulo")
	@Column(name = "nome")
	private String nome;

	@Column(name = "descricao")
	private String descricao;

	@Column(name = "url_imagem")
	private String urlImagem;

	@NotNull(message = "Valor de compra não pode ser nulo")
	@Min(value = 0, message = "Valor de compra não pode ser menor que zero")
	@Column(name = "valor_compra")
	private Double valorCompra;

	@NotNull(message = "Campo ValorVenda não pode ser nulo")
	@Min(value = 0, message = "Valor de venda não pode ser menor que zero")
	@Column(name = "valor_venda")
	private Double valorVenda;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Long getEstoque() {
		return estoque;
	}

	public void setEstoque(Long estoque) {
		this.estoque = estoque;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getUrlImagem() {
		return urlImagem;
	}

	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}

	public Double getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(Double valorCompra) {
		this.valorCompra = valorCompra;
	}

	public Double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(Double valorVenda) {
		this.valorVenda = valorVenda;
	}

}
