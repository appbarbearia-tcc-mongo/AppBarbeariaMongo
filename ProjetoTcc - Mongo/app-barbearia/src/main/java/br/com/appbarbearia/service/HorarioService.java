package br.com.appbarbearia.service;

import java.util.Calendar;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.appbarbearia.model.HoraDTO;
import br.com.appbarbearia.model.Horario;
import br.com.appbarbearia.repository.HorarioRepository;

@Service
public class HorarioService {

    @Autowired
    HorarioRepository horarioRepository;

    public Optional<Horario> getHorarioById(String id){
        Optional<Horario> opHorario = horarioRepository.findById(id);
        if(!opHorario.isPresent()){
            return Optional.empty();
        }
        return opHorario;
    }
    
    // Se o horario abertura for before() ou after() tira da lista
    public Calendar horaDtoToCalendar(HoraDTO horaDTO){
        return HoraDTO.toCalendar(horaDTO);
    } 

    public HoraDTO calendarToHoraDTO(Calendar calendar){
        return HoraDTO.toHoraDTO(calendar);
    }
}