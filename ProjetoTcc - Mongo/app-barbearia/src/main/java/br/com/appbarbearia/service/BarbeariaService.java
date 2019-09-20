package br.com.appbarbearia.service;

import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.appbarbearia.model.Barbearia;
import br.com.appbarbearia.repository.BarbeariaRepository;

@Service
public class BarbeariaService {
    Logger LOG = Logger.getLogger(BarbeariaService.class.getName());

    @Autowired
    BarbeariaRepository barbeariaRepository;

    public Optional<Barbearia> save(Barbearia barbearia) {
        Optional<Barbearia> opBarbearia = Optional.ofNullable(barbeariaRepository.save(barbearia));
        if (opBarbearia.isPresent()) {
            return opBarbearia;
        }
        return Optional.empty();
    }

    public Optional<Barbearia> findByCodigo(String id) {
        Optional<Barbearia> opBarbearia = barbeariaRepository.findById(id);
        if (opBarbearia.isPresent()) {
            return opBarbearia;
        }
        return Optional.empty();
    }

    public void delete(Barbearia barbearia) {
        barbeariaRepository.delete(barbearia);
    }

    public Optional<Barbearia> update(Barbearia barbearia) {
        Optional<Barbearia> opBarbearia = barbeariaRepository.findById(barbearia.getId());
        if (opBarbearia.isPresent()) {
            opBarbearia = save(barbearia);
            if (opBarbearia.isPresent()) {
                LOG.info("Barbearia alterado: " + opBarbearia.get().toString());
                return opBarbearia;
            } else {
                LOG.info("Barbearia informada não foi encontrada, portanto, não foi alterado");
                return Optional.empty();
            }
        }
        LOG.warning("Barbearia não foi encontrada, nenhum registro foi alterado");
        return Optional.empty();
    }

}