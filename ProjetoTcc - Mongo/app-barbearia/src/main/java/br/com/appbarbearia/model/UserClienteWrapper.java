package br.com.appbarbearia.model;

import java.io.Serializable;

public class UserClienteWrapper implements Serializable{

    private static final long serialVersionUID = 7469221621224282447L;

    private User user;
    private Cliente cliente;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

    

    
}