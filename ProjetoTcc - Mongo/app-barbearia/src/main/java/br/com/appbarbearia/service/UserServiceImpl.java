package br.com.appbarbearia.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.appbarbearia.model.Role;
import br.com.appbarbearia.model.User;
import br.com.appbarbearia.repository.RoleRepository;
import br.com.appbarbearia.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;
   
    @Autowired
    public BCryptPasswordEncoder bCryptPasswordEncoder;

    // @Bean
    // public BCryptPasswordEncoder bCryptPasswordEncoder() {
    //     BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    //     return bCryptPasswordEncoder;
    // }

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roleRepository.findAll().forEach(role -> {
            roles.add(role);
        });

        user.setRoles(roles);
        userRepository.save(user);
    }

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username).get();
	}

    

    
}