package com.LojaGames.model;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.LojaGames.repository.CategoriaRepository;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "tb_produtos")
public class ProdutoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O atributo nome é obrigatório")
	private String nome;
	
	@NotBlank(message = "O atributo marca é obrigatório")
	private String marca;
	
	@NotBlank(message = "O atributo plataforma é obrigatório")
	private String plataforma;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    @NotNull(message = "Preço é obrigatório!")
    @Positive(message = "O preço deve ser maior do que zero!")
    private BigDecimal preco;
	
	@NotNull(message = "A quantidade é obrigatória")
	private Integer quantidade;

	@ManyToOne
	@JsonIgnoreProperties("produtos")
	private CategoriaModel categoria;
	
	

	public CategoriaRepository getCategoria() {
		return CategoriaRepository;
	}

	public void setCategoria(CategoriaRepository categoria) {
		this.categoria = CategoriaRepository;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}
	
}


