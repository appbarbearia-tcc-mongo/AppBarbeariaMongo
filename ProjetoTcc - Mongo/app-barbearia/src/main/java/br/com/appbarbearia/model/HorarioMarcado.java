package br.com.appbarbearia.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "horarioMarcado")
public class HorarioMarcado implements Serializable {

	private static final long serialVersionUID = -4378450462277642167L;

	@Id
	private String id;
	@DBRef
	private Horario horario;
	@DBRef
	private Barbeiro barbeiro;
	@DBRef
	private Cliente cliente;
	private Date dia;
	private Date cadastro;
	private Date alterado;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public Barbeiro getBarbeiro() {
		return barbeiro;
	}

	public void setBarbeiro(Barbeiro barbeiro) {
		this.barbeiro = barbeiro;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getDia() {
		return dia;
	}

	public void setDia(Date dia) {
		this.dia = dia;
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
		return "HorarioMarcado [alterado=" + alterado + ", barbeiro=" + barbeiro + ", cadastro=" + cadastro
				+ ", cliente=" + cliente + ", dia=" + dia + ", horario=" + horario + ", id=" + id + "]";
	}

}