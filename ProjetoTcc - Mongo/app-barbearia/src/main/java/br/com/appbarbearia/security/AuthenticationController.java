package br.com.appbarbearia.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.appbarbearia.model.User;
import br.com.appbarbearia.service.UserServiceImpl;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/autenticacao")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @RequestMapping(value = "/obter-token", method = RequestMethod.POST)
    public ResponseEntity<String> register(@RequestBody User loginUser) throws AuthenticationException {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword()));
        final Optional<User> user = Optional.ofNullable(userServiceImpl.findByUsername(loginUser.getUsername()));
        if(user.isPresent()) {
            final String token = jwtTokenUtil.generateToken(user.get());
            return ResponseEntity.ok(token);
        } else {
        	return ResponseEntity.notFound().build();
        }
    }

}
