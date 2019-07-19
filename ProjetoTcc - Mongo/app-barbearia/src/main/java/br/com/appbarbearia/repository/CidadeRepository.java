package br.com.appbarbearia.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.appbarbearia.model.Cidade;

@Repository
@Transactional
public interface CidadeRepository extends PagingAndSortingRepository<Cidade, String> {

    public List<Cidade> findAll();

}