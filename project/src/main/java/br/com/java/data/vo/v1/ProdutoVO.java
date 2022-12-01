package br.com.java.data.vo.v1;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;

import jakarta.persistence.Column;
import jakarta.persistence.Table;

@Table
@JsonPropertyOrder({"id","nome","codigo","preco","marca","quantidade"})
public class ProdutoVO extends RepresentationModel<ProdutoVO> implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	

	@JsonProperty("id")
	@Mapping("id")
	public long key;
	@Column(nullable = false, length = 40)
	public String nome;
	@Column(nullable = false, length = 8)
	public int codigo;
	@Column(nullable = false)
	public double preco;
	@Column(nullable = false, length = 40)
	public String marca;
	@Column(nullable = false)
	public int quantidade;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public long getKey() {
		return key;
	}
	public void setKey(long key) {
		this.key = key;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	
	
	
	
	
			
}
