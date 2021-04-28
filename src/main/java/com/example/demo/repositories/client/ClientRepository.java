package com.example.demo.repositories.client;

import com.example.demo.entities.client.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long>, PagingAndSortingRepository<Client, Long> {

    Optional<Client> findById(long id);

}
