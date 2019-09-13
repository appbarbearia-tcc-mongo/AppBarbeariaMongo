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

import br.com.appbarbearia.model.Barbeiro;
import br.com.appbarbearia.service.BarbeiroService;

@RestController
@RequestMapping("api/barbeiro")
@CrossOrigin(origins = "*")
public class BarbeiroController {

    @Autowired
    private BarbeiroService barbeiroService;

    @PostMapping
    public ResponseEntity<Barbeiro> save(@RequestBody Barbeiro barbeiro) {
        Optional<Barbeiro> opBarbeiro = Optional.empty();
        if (barbeiro.getId() != null) {
            opBarbeiro = barbeiroService.edit(barbeiro);
        } else {
            opBarbeiro = barbeiroService.save(barbeiro);
        }

        if (!opBarbeiro.isPresent()) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(opBarbeiro.get());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Barbeiro> getBarbeiroById(@PathVariable("id") String id) {
        Optional<Barbeiro> opBarbeiro = barbeiroService.findById(id);

        if (!opBarbeiro.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(opBarbeiro.get());
    }

    @DeleteMapping("/id")
    public ResponseEntity<Barbeiro> deleteBarbeiro(@PathVariable("id") String id) {
        Optional<Barbeiro> opBarbeiro = barbeiroService.findById(id);

        if (!opBarbeiro.isPresent()) {
            return ResponseEntity.badRequest().build();
        }

        barbeiroService.delete(opBarbeiro.get());

        return ResponseEntity.noContent().build();
    }
}