package com.example.demo.helpers;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Setter
@Getter
public abstract class AbstractId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
