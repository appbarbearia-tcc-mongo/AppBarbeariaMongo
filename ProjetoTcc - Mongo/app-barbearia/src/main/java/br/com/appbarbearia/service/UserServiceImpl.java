package br.com.appbarbearia.service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.appbarbearia.model.User;
import br.com.appbarbearia.repository.RoleRepository;
import br.com.appbarbearia.repository.UserRepository;
import java.util.HashSet;


@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(user);
    }

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

    

    
}