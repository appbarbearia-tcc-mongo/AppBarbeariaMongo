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

import br.com.appbarbearia.model.Servico;
import br.com.appbarbearia.service.ServicoService;

@RestController
@RequestMapping("api/servico")
@CrossOrigin(origins = "*")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;
    
    @PostMapping
    public ResponseEntity<Servico> save(@RequestBody Servico servico){
        Optional<Servico> opServico = Optional.empty();
        if(servico.getId() != null){
            opServico = servicoService.edit(servico); 
        } else {
            opServico = servicoService.save(servico);
        }

        if(!opServico.isPresent()){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(opServico.get());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Servico> getServicoById(@PathVariable String id){
         Optional<Servico> opServico = servicoService.getServicoById(id);

         if(!opServico.isPresent()){
             return ResponseEntity.notFound().build();
         }

         return ResponseEntity.ok(opServico.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Servico> deleteServico(@PathVariable("id") String id){
        Optional<Servico> opServico = servicoService.getServicoById(id);

        if(!opServico.isPresent()){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.noContent().build();
    }

}