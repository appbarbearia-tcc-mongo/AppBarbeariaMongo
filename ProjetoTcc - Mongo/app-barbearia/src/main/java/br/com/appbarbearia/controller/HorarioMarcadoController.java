package br.com.appbarbearia.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.appbarbearia.model.Barbeiro;
import br.com.appbarbearia.model.Horario;
import br.com.appbarbearia.model.HorarioMarcado;
import br.com.appbarbearia.service.BarbeiroService;
import br.com.appbarbearia.service.HorarioMarcadoService;

@RestController
@RequestMapping("api/horarioMarcado")
@CrossOrigin(origins = "*")
public class HorarioMarcadoController {

    @Autowired
    private HorarioMarcadoService horarioMarcadoService;

    @Autowired
    private BarbeiroService barbeiroService;

    @GetMapping("/horariosDisponiveis/{barbeiro}/{data}")
    public ResponseEntity<List<Horario>> listaHorariosDisponiveis(@PathVariable String barbeiro, @PathVariable long data){
        Optional<Barbeiro> opBarbeiro = barbeiroService.findById(barbeiro);
        if(!opBarbeiro.isPresent()){
            return ResponseEntity.badRequest().build();    
        }
        List<Horario> horariosDisponiveis = new ArrayList<>();
        horariosDisponiveis = horarioMarcadoService.listaHorariosDisponiveisBarbeiro(opBarbeiro.get(), new Date(data));

        return ResponseEntity.ok().body(horariosDisponiveis);
    }

    @PostMapping
    public ResponseEntity<HorarioMarcado> save(@RequestBody HorarioMarcado horarioMarcado){
        Optional<HorarioMarcado> opHorarioMarcado = horarioMarcadoService.save(horarioMarcado);
        if(!opHorarioMarcado.isPresent()){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().body(opHorarioMarcado.get());
    }
}