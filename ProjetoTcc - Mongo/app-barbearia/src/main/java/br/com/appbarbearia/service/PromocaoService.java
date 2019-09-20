package br.com.appbarbearia.service;

import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.appbarbearia.model.Promocao;
import br.com.appbarbearia.repository.PromocaoRepository;

@Service
public class PromocaoService {

    Logger LOG = Logger.getLogger(PromocaoService.class.getName());

    @Autowired
    private PromocaoRepository promocaoRepository;

    public Optional<Promocao> save(Promocao promocao) {
        LOG.info("Salvando promoção: " + promocao.toString());
        return Optional.ofNullable(promocaoRepository.save(promocao));
    }

    public Optional<Promocao> edit(Promocao promocao) {
        LOG.info("Editando promoção: " + promocao.toString());
        return Optional.ofNullable(promocaoRepository.save(promocao));
    }

    public Optional<Promocao> getPromocaoById(String id) {
        LOG.info("Procurando promoção: " + id);
        return promocaoRepository.findById(id);
    }

    public void remove(Promocao promocao) {
        LOG.info("Removendo promoção: " + promocao.toString());
        promocaoRepository.delete(promocao);
    }
}