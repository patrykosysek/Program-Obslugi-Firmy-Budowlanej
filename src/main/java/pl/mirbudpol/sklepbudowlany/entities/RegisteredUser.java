package pl.mirbudpol.sklepbudowlany.entities;

import lombok.Getter;
import lombok.Setter;
import pl.mirbudpol.sklepbudowlany.additionalClasses.ID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Getter
@Setter
@Entity(name = "zarejestrowani_uzytkownicy")
public class RegisteredUser extends ID {


    @Column(unique = true, nullable = false)
    private String login;

    @Column(nullable = false)
    private String haslo;

    @Column(nullable = false)
    private int typUzytkownika;

    @Column(nullable = false)
    private boolean czyAktywne;

    @OneToOne
    @JoinColumn(name = "klient_id",referencedColumnName = "id")
    private Client client;

}

