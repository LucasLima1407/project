package br.com.java.data.vo.v1;


import java.io.Serializable;
import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;

@JsonPropertyOrder({"id","login","senha","nome","date"})
public class AdminVO extends RepresentationModel<AdminVO> implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("id")
	@Mapping("id")
	private long key;
	private String login;
	private String senha;
	private String nome;

	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public long getKey() {
		return key;
	}
	public void setKey(long key) {
		this.key = key;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(key, login, nome, senha);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		AdminVO other = (AdminVO) obj;
		return key == other.key && Objects.equals(login, other.login) && Objects.equals(nome, other.nome)
				&& Objects.equals(senha, other.senha);
	}
	
	
}