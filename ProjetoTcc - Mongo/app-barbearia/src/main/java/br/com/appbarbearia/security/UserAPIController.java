package br.com.appbarbearia.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.appbarbearia.model.Barbeiro;
import br.com.appbarbearia.model.Cliente;
import br.com.appbarbearia.model.UserBarbeiroWrapper;
import br.com.appbarbearia.model.UserClienteWrapper;
import br.com.appbarbearia.service.BarbeiroService;
import br.com.appbarbearia.service.ClienteService;
import br.com.appbarbearia.service.UserServiceImpl;

@RestController
@RequestMapping("api/user")
@CrossOrigin(origins = "*")
public class UserAPIController {

     @Autowired
     private UserServiceImpl userServiceImpl;

     @Autowired
     private ClienteService clienteService;

     @Autowired
     private BarbeiroService barbeiroService;

     @PostMapping("/cliente")
     public ResponseEntity<Cliente> createNewUser(@RequestBody UserClienteWrapper userWrapper) {
          userServiceImpl.save(userWrapper.getUser());
          clienteService.save(userWrapper.getCliente());
          return ResponseEntity.ok().body(userWrapper.getCliente());
     }

     @PostMapping("/barbeiro")
     public ResponseEntity<Barbeiro> createNewBarbeiro(@RequestBody UserBarbeiroWrapper userWrapper) {
          userServiceImpl.save(userWrapper.getUser());
          barbeiroService.save(userWrapper.getBarbeiro());

          return ResponseEntity.ok().body(userWrapper.getBarbeiro());
     }

}