package br.com.appbarbearia.service;

import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.appbarbearia.model.Servico;
import br.com.appbarbearia.repository.ServicoRepository;

@Service
public class ServicoService {

    private final Logger LOG = Logger.getLogger(ServicoService.class.getName());

    @Autowired
    private ServicoRepository servicoRepository;

    public Optional<Servico> save(Servico servico) {
        LOG.info("Salvando servico: " + servico.toString());

        return Optional.ofNullable(servicoRepository.save(servico));
    }

    public Optional<Servico> edit(Servico servico) {
        LOG.info("Editando servico: " + servico.toString());

        return Optional.ofNullable(servicoRepository.save(servico));
    }

    public Optional<Servico> getServicoById(String id) {
        LOG.info("Procurando servico: " + id);
        return servicoRepository.findById(id);
    }

    public void remove(Servico servico) {
        LOG.info("Excluindo servico: " + servico.toString());
        servicoRepository.delete(servico);
    }
}