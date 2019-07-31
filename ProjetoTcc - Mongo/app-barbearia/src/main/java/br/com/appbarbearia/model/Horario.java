package br.com.appbarbearia.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "horario")
public class Horario implements Serializable {

	private static final long serialVersionUID = -941515513807208076L;

	@Id
	private String id;
	private String descricao;
	private HoraDTO horaDTO;
	private Date hora;
	private Date cadastro;
	private Date alterado;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public HoraDTO getHoraDTO() {
		return horaDTO;
	}

	public void setHoraDTO(HoraDTO horaDTO) {
		this.horaDTO = horaDTO;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
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
		return "Horario [id=" + id + ", descricao=" + descricao + ", hora=" + hora + ", cadastro=" + cadastro
				+ ", alterado=" + alterado + "]";
	}

}
