package br.com.appbarbearia.service;

import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.appbarbearia.model.Cliente;
import br.com.appbarbearia.repository.ClienteRepository;

@Service
public class ClienteService {

    public final Logger LOG = Logger.getLogger(ClienteService.class.getName());

    @Autowired
    private ClienteRepository clienteRepository;

    public Optional<Cliente> save(Cliente cliente) {
        LOG.info("Salvando cliente: " + cliente.toString());
        return Optional.ofNullable(clienteRepository.save(cliente));
    }

    public Optional<Cliente> getClienteById(String id) {
        LOG.info("Procurando cliente com Id: " + id);
        return clienteRepository.findById(id);
    }

    public Optional<Cliente> editCliente(Cliente cliente) {
        LOG.info("Editando cliente: " + cliente.toString());
        return Optional.ofNullable(clienteRepository.save(cliente));
    }

    public void removeCliente(Cliente cliente) {
        LOG.info("Removendo cliente: " + cliente.toString());
        clienteRepository.delete(cliente);
    }
}