package br.com.appbarbearia.service;

import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.appbarbearia.model.Barbeiro;
import br.com.appbarbearia.repository.BarbeiroRepository;

@Service
public class BarbeiroService {

    Logger LOG = Logger.getLogger(BarbeiroService.class.getName());

    @Autowired
    BarbeiroRepository barbeiroRepository;

    
    public Optional<Barbeiro> save(Barbeiro barbeiro) {
        LOG.info("Salvando promoção: " + barbeiro.toString());
        return Optional.ofNullable(barbeiroRepository.save(barbeiro));
    }

    public Optional<Barbeiro> edit(Barbeiro barbeiro) {
        LOG.info("Editando promoção: " + barbeiro.toString());
        return Optional.ofNullable(barbeiroRepository.save(barbeiro));
    }

    public Optional<Barbeiro> getBarbeiroById(String id) {
        LOG.info("Procurando promoção: " + id);
        return barbeiroRepository.findById(id);
    }

    public void remove(Barbeiro barbeiro) {
        LOG.info("Removendo promoção: " + barbeiro.toString());
        barbeiroRepository.delete(barbeiro);
    }
}