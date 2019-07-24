package br.com.appbarbearia.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.appbarbearia.model.HorarioMarcado;

@Repository
@Transactional
public interface HorarioMarcadoRepository extends MongoRepository<HorarioMarcado, String>{

    public List<HorarioMarcado> findByDiaBetween(Date inicio, Date fim);
    
}