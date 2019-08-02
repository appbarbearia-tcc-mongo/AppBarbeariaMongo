package br.com.appbarbearia.model;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "promocao")
public class Promocao implements Serializable {

	private static final long serialVersionUID = 4201583534980049131L;

	@Id
	private String id;
	@DBRef
	private Servico servico;
	@DBRef
	private Barbearia barbearia;
	private String descricao;
	private double valorDesconto;
	private int porcentagemDesconto;
	private Calendar dataInicio;
	private Calendar dataTermino;
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
	
	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
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

	public double getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(double valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public int getPorcentagemDesconto() {
		return porcentagemDesconto;
	}

	public void setPorcentagemDesconto(int porcentagemDesconto) {
		this.porcentagemDesconto = porcentagemDesconto;
	}

	public Calendar getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Calendar getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Calendar dataTermino) {
		this.dataTermino = dataTermino;
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
		return "Promocao [alterado=" + alterado + ", barbearia=" + barbearia + ", cadastro=" + cadastro + ", id="
				+ id + ", dataInicio=" + dataInicio + ", dataTermino=" + dataTermino + ", descricao=" + descricao
				+ ", porcentagemDesconto=" + porcentagemDesconto + ", servico=" + servico + ", valorDesconto="
				+ valorDesconto + "]";
	}
	
}
