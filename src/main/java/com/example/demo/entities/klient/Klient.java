package com.example.demo.entities.klient;

import com.example.demo.helpers.AbstractId;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Email;

@Getter
@Setter
@Entity(name = "klienci")
public class Klient extends AbstractId{

    @Column(nullable = false)
    private String imie;

    @Column
    private String nazwisko;

    @Column
    private String email;

}
