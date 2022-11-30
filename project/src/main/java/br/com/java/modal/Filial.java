package br.com.java.modal;

import java.io.Serializable;

import jakarta.persistence.Entity;


public class Filial implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public long id;
	public String nome;
	public String localizacao;
	
}
