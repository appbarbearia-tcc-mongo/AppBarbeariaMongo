package br.com.appbarbearia.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import br.com.appbarbearia.model.User;

@Repository
@Transactional
public interface UserRepository extends PagingAndSortingRepository<User, String> {
    User findByUsername(String username);

}
