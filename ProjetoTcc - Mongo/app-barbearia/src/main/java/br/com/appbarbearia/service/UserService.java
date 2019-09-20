package br.com.appbarbearia.service;

import br.com.appbarbearia.model.User;

/**
 * UserService
 */
public interface UserService {
    void save(User user);
    
    User findByUsername(String username);
}