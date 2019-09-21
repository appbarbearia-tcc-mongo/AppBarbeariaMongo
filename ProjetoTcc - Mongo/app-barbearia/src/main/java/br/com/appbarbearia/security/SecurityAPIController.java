package br.com.appbarbearia.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.appbarbearia.model.User;
import br.com.appbarbearia.service.UserServiceImpl;

@RestController
@RequestMapping("api/security")
@CrossOrigin(origins = "*")
public class SecurityAPIController {

    
    @Autowired
    private UserServiceImpl userServiceImpl;

   @PostMapping("/new")
   public ResponseEntity<User> createNewUser(@RequestBody User user){
        userServiceImpl.save(user);

        return ResponseEntity.ok().body(user);
   }

}