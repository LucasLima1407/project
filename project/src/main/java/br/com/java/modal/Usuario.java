package br.com.java.modal;

import java.io.Serializable;
import java.util.Objects;

import javax.xml.crypto.Data;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false, length = 40)
	private String nome;
	@Column(nullable = false, length = 40)
	private String cpf;
	@Column(name = "data_Nasci",nullable = false, length = 11)
	private Data dateNasc;
	@Column(nullable = false, length = 9)
	private String celular;
	@Column(nullable = false, length = 40)
	private String endereco;
	@Column(nullable = false, length = 40)
	private String login;
	@Column(nullable = false, length = 40)
	private String senha;
	@Column(nullable = false)
	public long idFilial;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Data getDateNasc() {
		return dateNasc;
	}
	public void setDateNasc(Data dateNasc) {
		this.dateNasc = dateNasc;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
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
	public long getIdFilial() {
		return idFilial;
	}
	public void setIdFilial(long idFilial) {
		this.idFilial = idFilial;
	}
	@Override
	public int hashCode() {
		return Objects.hash(celular, cpf, dateNasc, endereco, id, idFilial, login, nome, senha);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(celular, other.celular) && Objects.equals(cpf, other.cpf)
				&& Objects.equals(dateNasc, other.dateNasc) && Objects.equals(endereco, other.endereco)
				&& id == other.id && idFilial == other.idFilial && Objects.equals(login, other.login)
				&& Objects.equals(nome, other.nome) && Objects.equals(senha, other.senha);
	}
	
	
	
}
