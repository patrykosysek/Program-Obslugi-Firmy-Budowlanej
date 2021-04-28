package com.example.demo.dtos.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KlientDTO {

    private Long id;

    @NotNull
    private String imie;


    private String nazwisko;

    @Email
    private String email;

    public KlientDTO(String imie, String nazwisko, String email) {
        this(null, imie, nazwisko,email);
    }

}