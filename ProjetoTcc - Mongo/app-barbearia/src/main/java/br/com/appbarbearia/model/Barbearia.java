package br.com.appbarbearia.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "barbearia")
public class Barbearia implements Serializable {

	private static final long serialVersionUID = -1931496073277262115L;

	@Id
	private String id;
	private String nome;
	private String descricao;
	private String cidade;
	private String endereco;
	private Estados estado;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:MM:dd")
	private Date horarioAbertura;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:MM:dd")
	private Date horarioFechamento;
	private Date cadastro;
	private Date alterado;
	@DBRef
	private List<Servico> servicos;
	@DBRef
	private List<Barbeiro> barbeiros;
	@DBRef
	private List<Promocao> promocoes;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Estados getEstado() {
		return estado;
	}

	public void setEstado(Estados estado) {
		this.estado = estado;
	}

	public Date getHorarioAbertura() {
		return horarioAbertura;
	}

	public void setHorarioAbertura(Date horarioAbertura) {
		this.horarioAbertura = horarioAbertura;
	}

	public Date getHorarioFechamento() {
		return horarioFechamento;
	}

	public void setHorarioFechamento(Date horarioFechamento) {
		this.horarioFechamento = horarioFechamento;
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

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

	public List<Barbeiro> getBarbeiros() {
		return barbeiros;
	}

	public void setBarbeiros(List<Barbeiro> barbeiros) {
		this.barbeiros = barbeiros;
	}

	public List<Promocao> getPromocoes() {
		return promocoes;
	}

	public void setPromocoes(List<Promocao> promocoes) {
		this.promocoes = promocoes;
	}

	@Override
	public String toString() {
		return "Barbearia [alterado=" + alterado + ", barbeiros=" + barbeiros + ", cadastro=" + cadastro + ", id="
				+ id + ", descricao=" + descricao + ", endereco=" + endereco + ", horarioAbertura="
				+ horarioAbertura + ", horarioFechamento=" + horarioFechamento + ", nome=" + nome + ", promocoes="
				+ promocoes + ", servicos=" + servicos + "]";
	}
	
}
