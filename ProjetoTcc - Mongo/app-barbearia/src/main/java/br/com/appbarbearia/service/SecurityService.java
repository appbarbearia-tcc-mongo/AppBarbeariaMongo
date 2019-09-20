package br.com.appbarbearia.service;

public interface SecurityService {
    String findLoggedInUsername();

    static void autoLogin(String username, String password) {
		// TODO Auto-generated method stub
		
	}
}