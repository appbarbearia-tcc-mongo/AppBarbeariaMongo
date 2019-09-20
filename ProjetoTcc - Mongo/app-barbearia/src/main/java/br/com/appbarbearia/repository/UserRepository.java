package br.com.appbarbearia.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import br.com.appbarbearia.model.User;

@Repository
@Transactional
public interface UserRepository extends PagingAndSortingRepository<User, String> {

    Optional<User> findByUsername(String username);

}
