package com.example.demo.repositories.klient;

import com.example.demo.entities.client.Client;
import com.example.demo.entities.klient.Klient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


    @Repository
    public interface KlientRepository extends CrudRepository<Klient, Long>, PagingAndSortingRepository<Klient, Long> {

        Optional<Client> findById(long id);

    }

