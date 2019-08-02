package br.com.appbarbearia.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:MM:dd")
	private Date dia;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:MM:dd")
	private Date cadastro;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:MM:dd")
	private Date alterado;

	public HorarioMarcado(){

	}

	private HorarioMarcado(HorarioMarcadoBuilder builder) {
		this.id = builder.id;
		this.horario = builder.horario;
		this.barbeiro = builder.barbeiro;
		this.cliente = builder.cliente;
		this.dia = builder.dia;
		this.cadastro = builder.cadastro;
		this.alterado = builder.alterado;
	}

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

	public static HorarioMarcadoBuilder builder() {
		return new HorarioMarcadoBuilder();
	}

	public static final class HorarioMarcadoBuilder {
		private String id;
		private Horario horario;
		private Barbeiro barbeiro;
		private Cliente cliente;
		private Date dia;
		private Date cadastro;
		private Date alterado;

		private HorarioMarcadoBuilder() {
		}

		public HorarioMarcadoBuilder withId(String id) {
			this.id = id;
			return this;
		}

		public HorarioMarcadoBuilder withHorario(Horario horario) {
			this.horario = horario;
			return this;
		}

		public HorarioMarcadoBuilder withBarbeiro(Barbeiro barbeiro) {
			this.barbeiro = barbeiro;
			return this;
		}

		public HorarioMarcadoBuilder withCliente(Cliente cliente) {
			this.cliente = cliente;
			return this;
		}

		public HorarioMarcadoBuilder withDia(Date dia) {
			this.dia = dia;
			return this;
		}

		public HorarioMarcadoBuilder withCadastro(Date cadastro) {
			this.cadastro = cadastro;
			return this;
		}

		public HorarioMarcadoBuilder withAlterado(Date alterado) {
			this.alterado = alterado;
			return this;
		}

		public HorarioMarcado build() {
			return new HorarioMarcado(this);
		}
	}
}