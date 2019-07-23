package br.com.appbarbearia.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.appbarbearia.model.Barbeiro;
import br.com.appbarbearia.model.Horario;
import br.com.appbarbearia.model.HorarioMarcado;
import br.com.appbarbearia.repository.HorarioMarcadoRepository;
import br.com.appbarbearia.repository.HorarioRepository;

@Service
public class HorarioMarcadoService {

    Logger LOG = Logger.getLogger(HorarioMarcadoService.class.getName());

    @Autowired
    HorarioMarcadoRepository horarioMarcadoRepository;
    
    @Autowired
    HorarioRepository horarioRepository;

    public Optional<HorarioMarcado> save(HorarioMarcado horarioMarcado){
        Optional<HorarioMarcado> opHorarioMarcado = Optional.ofNullable(horarioMarcadoRepository.save(horarioMarcado));
        if(!opHorarioMarcado.isPresent()){
            LOG.severe("Horario marcado não foi salvo");
            return Optional.empty();
        }
        LOG.info("Horario marcado salvo com sucesso!");
        return opHorarioMarcado;
    }

    public List<Horario> listaHorariosDisponiveisBarbeiro(Barbeiro barbeiro, Date date) {
        List<Horario> horarios = horarioRepository.findByHoraBetween(barbeiro.getBarbearia().getHorarioAbertura(), barbeiro.getBarbearia().getHorarioFechamento());
        List<HorarioMarcado> horariosMarcados = horarioMarcadoRepository.findByDiaBetween(date, date);
        List<Horario> horariosDisponiveis = new ArrayList<>();
        horariosMarcados.stream().forEach(hm -> {
            Optional<Horario> opHorario = horarios.stream().filter(h -> h.equals(hm.getHorario())).findAny();
            if (!opHorario.isPresent()) {
                horariosDisponiveis.add(opHorario.get());
            }
        });
        if (horariosDisponiveis != null && !horariosDisponiveis.isEmpty()) {
            return horariosDisponiveis;
        } else {
            return new ArrayList<>();
        }
    }
}