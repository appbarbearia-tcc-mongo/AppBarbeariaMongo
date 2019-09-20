package br.com.appbarbearia.service;

import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.appbarbearia.model.Barbeiro;
import br.com.appbarbearia.repository.BarbeiroRepository;

@Service
public class BarbeiroService {

    @Autowired
    BarbeiroRepository barbeiroRepository;

    private final Logger LOG = Logger.getLogger(BarbeiroService.class.getName());

    public Optional<Barbeiro> findById(String id){
        return barbeiroRepository.findById(id);
    }

    public Optional<Barbeiro> save(Barbeiro barbeiro){
        LOG.info("Salvando barbeiro: " + barbeiro.toString());
    
        return Optional.ofNullable(barbeiroRepository.save(barbeiro));
    }

    public Optional<Barbeiro> edit(Barbeiro barbeiro){
        LOG.info("Editando barbeiro: " + barbeiro.toString());
    
        return Optional.ofNullable(barbeiroRepository.save(barbeiro));
    }

    public void delete(Barbeiro barbeiro){
        LOG.info("Excluindo barbeiro" + barbeiro.toString());

        barbeiroRepository.delete(barbeiro);
    }
}