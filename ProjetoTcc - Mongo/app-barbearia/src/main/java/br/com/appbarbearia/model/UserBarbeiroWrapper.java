package br.com.appbarbearia.model;

import java.io.Serializable;

public class UserBarbeiroWrapper implements Serializable {

    private static final long serialVersionUID = 5979156351648808543L;

    private User user;
    private Barbeiro barbeiro;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Barbeiro getBarbeiro() {
        return barbeiro;
    }

    public void setBarbeiro(Barbeiro barbeiro) {
        this.barbeiro = barbeiro;
    }

}