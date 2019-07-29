package br.com.appbarbearia.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.appbarbearia.model.Barbeiro;
import br.com.appbarbearia.repository.BarbeiroRepository;

@Service
public class BarbeiroService {

    @Autowired
    BarbeiroRepository barbeiroRepository;

    public Optional<Barbeiro> findById(String id){
        return barbeiroRepository.findById(id);
    }
}