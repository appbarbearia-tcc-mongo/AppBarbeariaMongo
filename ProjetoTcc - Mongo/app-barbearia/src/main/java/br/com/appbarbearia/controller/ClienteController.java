package br.com.appbarbearia.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.appbarbearia.model.Cliente;
import br.com.appbarbearia.service.ClienteService;

@RestController
@RequestMapping("api/cliente")
@CrossOrigin(origins = "*")
public class ClienteController {

    
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable("id") String id){
        Optional<Cliente> opCliente = clienteService.getClienteById(id);
        
        if(!opCliente.isPresent()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(opCliente.get());
    }

    @PostMapping
    public ResponseEntity<Cliente> save(@RequestBody Cliente cliente){
        Optional<Cliente> opCliente = Optional.empty();
        if(cliente.getId() != null){
            opCliente = clienteService.editCliente(cliente);
        } else {
            opCliente = clienteService.save(cliente);
        }

        if(!opCliente.isPresent()){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> delete(@PathVariable("id") String id){
        Optional<Cliente> opCliente = clienteService.getClienteById(id);

        if(!opCliente.isPresent()){
            return ResponseEntity.badRequest().build();
        }
        clienteService.removeCliente(opCliente.get());

        return ResponseEntity.noContent().build();
        
    }

}