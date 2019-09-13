package br.com.appbarbearia.controller;

import java.util.Calendar;
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

import br.com.appbarbearia.model.Promocao;
import br.com.appbarbearia.service.PromocaoService;

@RestController
@RequestMapping("api/promocao")
@CrossOrigin(origins = "*")
public class PromocaoController {

    Calendar calendar = Calendar.getInstance();

    @Autowired
    private PromocaoService promocaoService;

    @GetMapping("/{id}")
    public ResponseEntity<Promocao> findPromocaoById(@PathVariable("id") String id){

        Optional<Promocao> opPromocao = promocaoService.getPromocaoById(id);

        if(opPromocao.isPresent()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(opPromocao.get());
    }

    @PostMapping
    public ResponseEntity<Promocao> save(@RequestBody Promocao promocao){
        Optional<Promocao> opPromocao = Optional.empty();

        if (promocao.getId() != null){
            opPromocao = promocaoService.edit(promocao); 
        } else {
            opPromocao = promocaoService.save(promocao);
        }

        if (!opPromocao.isPresent()){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(promocao);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Promocao> delete(@PathVariable("id") String id){

        Optional<Promocao> opPromocao = promocaoService.getPromocaoById(id);

        if(!opPromocao.isPresent()){
            ResponseEntity.badRequest().build();
        }

        promocaoService.remove(opPromocao.get());
        return ResponseEntity.noContent().build();
    }

}