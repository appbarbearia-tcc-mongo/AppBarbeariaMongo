package br.com.appbarbearia.service;

import java.util.ArrayList;
import java.util.Calendar;
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
        // List<Horario> horarios = horarioRepository.findByHoraBetween(barbeiro.getBarbearia().getHorarioAbertura(), barbeiro.getBarbearia().getHorarioFechamento());
        List<Horario> horarios = horarioRepository.findAll();
        // TODO: CRIAR 2 CALENDARS, UM COMEÇA EM 00:00 E O OUTRO ACABA EM 23:59 DO MESMO DIA
        Calendar inicio = Calendar.getInstance();
        Calendar fim = Calendar.getInstance();
        setUpDates(inicio, fim, date);
        List<HorarioMarcado> horariosMarcados = horarioMarcadoRepository.findByDiaBetween(inicio.getTime(), fim.getTime());
        List<Horario> horariosDisponiveis = new ArrayList<>();
        horarios.stream().forEach(h -> {
            Optional<HorarioMarcado> opHorarioMarcado = horariosMarcados.stream().filter(hm -> hm.getHorario().getId().equals(h.getId())).findAny();
            if (!opHorarioMarcado.isPresent()) {
                horariosDisponiveis.add(h);
            }
        });
        if (horariosDisponiveis != null && !horariosDisponiveis.isEmpty()) {
            return horariosDisponiveis;
        } else {
            return new ArrayList<>();
        }
    }

    private void setUpDates(Calendar inicio, Calendar fim, Date date){
        inicio.setTime(date);
        fim.setTime(date);
        inicio.set(Calendar.HOUR, 0);
        inicio.set(Calendar.MINUTE, 0);
        inicio.set(Calendar.SECOND, 0);
        fim.set(Calendar.HOUR, 23);
        fim.set(Calendar.MINUTE, 59);
        fim.set(Calendar.SECOND, 59);
    }
}