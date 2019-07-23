package br.com.appbarbearia.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.appbarbearia.model.Cliente;

@Repository
@Transactional
public interface ClienteRepository extends PagingAndSortingRepository<Cliente, String>{

    
}