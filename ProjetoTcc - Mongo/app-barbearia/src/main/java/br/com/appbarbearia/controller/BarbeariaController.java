package br.com.appbarbearia.controller;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.appbarbearia.model.Barbearia;
import br.com.appbarbearia.service.BarbeariaService;

@RestController
@RequestMapping("api/barbearia")
@CrossOrigin(origins = "*")
public class BarbeariaController {

    Logger LOG = Logger.getLogger(BarbeariaController.class.getName());

    @Autowired
    private BarbeariaService barbeariaService;

    @PostMapping
    public ResponseEntity<Barbearia> save(Barbearia barbearia){

        Optional<Barbearia> opBarbearia = barbeariaService.save(barbearia);

        if(!opBarbearia.isPresent()){
            LOG.log(Level.WARNING, "Não foi possivel salvar a barbearia" + barbearia.toString());
            return ResponseEntity.badRequest().build();
        }
        
        LOG.log(Level.INFO, "Barbearia salva com sucesso!");
        return ResponseEntity.ok().body(barbearia);
    }
    
}