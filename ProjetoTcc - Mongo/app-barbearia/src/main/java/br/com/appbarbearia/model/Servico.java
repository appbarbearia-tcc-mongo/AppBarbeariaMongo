package br.com.appbarbearia.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "servico")
public class Servico implements Serializable {

	private static final long serialVersionUID = -3694300017473668994L;

	@Id
	private String id;
	@DBRef
	private Barbearia barbearia;
	private String descricao;
	private double preco;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:MM:dd")
	private Date cadastro;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:MM:dd")
	private Date alterado;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Barbearia getBarbearia() {
		return barbearia;
	}

	public void setBarbearia(Barbearia barbearia) {
		this.barbearia = barbearia;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Date getCadastro() {
		return cadastro;
	}

	public void setCadastro(Date cadastro) {
		this.cadastro = cadastro;
	}

	public Date getAlterado() {
		return alterado;
	}

	public void setAlterado(Date alterado) {
		this.alterado = alterado;
	}

	@Override
	public String toString() {
		return "Servico [alterado=" + alterado + ", barbearia=" + barbearia + ", cadastro=" + cadastro + ", id="
				+ id + ", descricao=" + descricao + ", preco=" + preco + "]";
	}

}
