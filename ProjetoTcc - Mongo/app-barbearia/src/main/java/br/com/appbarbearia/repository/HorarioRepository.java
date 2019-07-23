package br.com.appbarbearia.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.appbarbearia.model.Horario;

@Repository
@Transactional
public interface HorarioRepository extends PagingAndSortingRepository<Horario, String>{

    public List<Horario> findAll();

    public List<Horario> findByHoraBetween(Date dataInicio, Date dataTermino);
    
}