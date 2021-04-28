package com.example.demo.repositories.activity;

import com.example.demo.entities.Activity;
import com.example.demo.entities.client.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;



    @Repository
    public interface ActivityRepository extends CrudRepository<Activity, Long>, PagingAndSortingRepository<Activity, Long> {

        Optional<Activity> findById(long id);

    }

